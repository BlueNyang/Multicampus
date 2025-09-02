package com.mc.j_adopter.user;

import com.mc.j_adopter.auth.AuthService;
import com.mc.j_adopter.auth.SocialLoginProvider;

public class UserController {
    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    public int googleLogin() {
        authService.socialLogin(SocialLoginProvider.GOOGLE, "abc");
        return 200;
    }

    public int naverLogin() {
        authService.socialLogin(SocialLoginProvider.NAVER, "zyx");
        return 200;
    }
}
