package com.mc.musiccoordinator.infra.llm;

import com.mc.musiccoordinator.infra.llm.BaseModel;
import com.mc.musiccoordinator.infra.llm.gemini.chat.GeminiChatModel;

public enum LLMProvider {
    GEMINI;


    LLMProvider() {
    }

    public BaseModel create(String url, String apiKey) {
        return switch (this) {
            case GEMINI -> GeminiChatModel.getInstance(url, apiKey);
        };
    }
}
