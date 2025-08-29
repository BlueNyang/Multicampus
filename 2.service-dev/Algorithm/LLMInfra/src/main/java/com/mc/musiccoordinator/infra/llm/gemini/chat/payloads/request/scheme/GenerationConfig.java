package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme;

public record GenerationConfig<T>(String responseMimeType, ResponseSchema<T> responseSchema) {
    public GenerationConfig(ResponseSchema<T> responseSchema) {
        this("application/json", responseSchema);
    }
}
