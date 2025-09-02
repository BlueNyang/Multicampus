package com.mc.musiccoordinator.infra.llm.gemini.chat;

import com.google.gson.reflect.TypeToken;
import com.mc.musiccoordinator.infra.json.JsonProvider;
import com.mc.musiccoordinator.infra.llm.BaseResponse;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.ResponseDocument;

import java.util.List;
import java.util.Map;

public class GeminiResponse implements BaseResponse {
    private final ResponseDocument response;

    public GeminiResponse(String response) {
        this.response = JsonProvider.gson().fromJson(response, ResponseDocument.class);
    }

    @Override
    public List<Map<String, Object>> messageToMap() {
        if (this.response.candidates() != null && !this.response.candidates().isEmpty()) {
            String text = this.response.candidates().getFirst().content().parts().getFirst().text();

            TypeToken<List<Map<String, Object>>> listTypeToken = new TypeToken<>() {
            };
            return JsonProvider.gson().fromJson(text, listTypeToken.getType());
        } else {
            String error = this.response.error() != null ? this.response.error().message() : "Unknown error";
            return List.of(Map.of("error", error));
        }
    }

    @Override
    public boolean errorExists() {
        return this.response.error() != null;
    }

    @Override
    public String getErrorStatus() {
        if (this.response.error() == null) {
            return null;
        }
        return this.response.error().status();
    }

    @Override
    public String getErrorMessage() {
        if (this.response.error() == null) {
            return null;
        }
        return this.response.error().message();
    }
}
