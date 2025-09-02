package com.mc.j_adopter.auth.adoptor;

import com.mc.j_adopter.api.google.GoogleApi;
import com.mc.j_adopter.api.google.GoogleProfile;
import com.mc.j_adopter.auth.SocialLogin;
import com.mc.j_adopter.user.UserProfile;

public class GoogleAdaptor implements SocialLogin {
    private final GoogleApi api = new GoogleApi();

    @Override
    public UserProfile login(String token) {
        GoogleProfile profile = api.getProfile(token);
        return new UserProfile(profile.name(), profile.email());
    }
}
