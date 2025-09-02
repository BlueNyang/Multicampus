package com.mc.musiccoordinator.infra.llm;

public class LLMContext {
    public LLMContext() {
    }

    public BaseModel initChatModel(LLMProvider llmProvider, String url, String apiKey) {
        return llmProvider.create(url, apiKey);
    }
}
