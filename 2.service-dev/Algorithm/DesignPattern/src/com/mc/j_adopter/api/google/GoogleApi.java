package com.mc.j_adopter.api.google;

public class GoogleApi {
    public GoogleProfile getProfile(String token) {
        return new GoogleProfile("GUEST", "example@gmail.com");
    }
}
