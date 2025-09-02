package com.mc.musiccoordinator.infra.llm.gemini.chat.commons;

import java.util.List;

public record Items<T>(String type, T properties, List<String> propertyOrdering) {
    public Items(String type, T properties) {
        this(type, properties, null);
    }
}
