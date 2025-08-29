package com.mc.musiccoordinator.infra.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonProvider {
    private static final Gson instance;

    static {
        instance = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public static Gson gson() {
        return instance;
    }
}
