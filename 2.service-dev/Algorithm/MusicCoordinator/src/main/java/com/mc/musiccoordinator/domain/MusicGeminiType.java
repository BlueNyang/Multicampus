package com.mc.musiccoordinator.domain;

import com.mc.musiccoordinator.infra.llm.Format;
import com.mc.musiccoordinator.infra.llm.gemini.chat.SchemaType;

public record MusicGeminiType(
        SchemaType name,
        SchemaType artist,
        SchemaType reason
) implements Format {
    public static final MusicGeminiType INSTANCE = new MusicGeminiType(
            new SchemaType("STRING"),
            new SchemaType("STRING"),
            new SchemaType("STRING")
    );
}
