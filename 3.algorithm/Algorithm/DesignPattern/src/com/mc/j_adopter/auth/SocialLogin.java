package com.mc.j_adopter.auth;

import com.mc.j_adopter.user.UserProfile;

public interface SocialLogin {
    UserProfile login(String token);
}
