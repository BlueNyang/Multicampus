package com.mc.j_adopter.auth.adoptor;

import com.mc.j_adopter.api.naver.NaverApi;
import com.mc.j_adopter.api.naver.NaverProfile;
import com.mc.j_adopter.auth.SocialLogin;
import com.mc.j_adopter.user.UserProfile;

public class NaverAdaptor implements SocialLogin {
    private final NaverApi api = new NaverApi();

    @Override
    public UserProfile login(String token) {
        NaverProfile profile = api.getProfile(token);
        return new UserProfile(profile.name(), profile.email());
    }
}
