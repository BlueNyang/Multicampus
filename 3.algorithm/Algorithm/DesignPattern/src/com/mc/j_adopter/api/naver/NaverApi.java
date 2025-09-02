package com.mc.j_adopter.api.naver;

public class NaverApi {
    public NaverProfile getProfile(String token) {
        return new NaverProfile("GUEST", "example@gmail.com");
    }
}
