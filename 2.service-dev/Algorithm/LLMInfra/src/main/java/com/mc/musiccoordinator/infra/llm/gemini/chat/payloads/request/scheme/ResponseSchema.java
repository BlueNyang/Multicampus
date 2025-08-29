package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme;

import com.mc.musiccoordinator.infra.llm.gemini.chat.commons.Items;

public record ResponseSchema<T>(String type, Items<T> items) {
    public ResponseSchema(String type) {
        this(type, null);
    }

    public ResponseSchema(Items<T> items) {
        this("ARRAY", items);
    }
}
