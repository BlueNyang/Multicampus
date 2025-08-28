package com.mc.j_adopter.auth;

import com.mc.j_adopter.auth.adoptor.GoogleAdaptor;
import com.mc.j_adopter.auth.adoptor.NaverAdaptor;
import com.mc.j_adopter.user.UserProfile;

public class AuthService {
    public void socialLogin(SocialLoginProvider provider, String token) {
        SocialLogin socialLogin = switch (provider) {
            case GOOGLE -> new GoogleAdaptor();
            case NAVER -> new NaverAdaptor();
        };

        UserProfile userProfile = socialLogin.login(token);
        System.out.println(userProfile.username() + ": start login logic...");
    }
}
