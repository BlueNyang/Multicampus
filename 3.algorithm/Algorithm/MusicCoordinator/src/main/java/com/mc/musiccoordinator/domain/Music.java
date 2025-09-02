package com.mc.musiccoordinator.domain;

import java.util.Map;

public record Music(
        String name,
        String artist,
        String reason
) {
    public static Music fromMap(Map<String, Object> map) {
        return new Music((String) map.get("name")
                , (String) map.get("artist")
                , (String) map.get("reason"));
    }
}
