package com.mc.musiccoordinator.infra.llm.gemini.chat;

import com.mc.musiccoordinator.infra.json.JsonProvider;
import com.mc.musiccoordinator.infra.llm.BaseRequest;
import com.mc.musiccoordinator.infra.llm.Format;
import com.mc.musiccoordinator.infra.llm.gemini.chat.commons.Items;
import com.mc.musiccoordinator.infra.llm.gemini.chat.commons.Part;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.RequestDocument;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme.Contents;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme.GenerationConfig;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme.ResponseSchema;

import java.util.List;

public class GeminiRequest<T extends Format> implements BaseRequest {
    String content;
    T format;

    public GeminiRequest(String content, T format) {
        this.content = content;
        this.format = format;
    }

    @Override
    public String messageToJson() {
        ResponseSchema<T> schema =
                new ResponseSchema<>("array", new Items<>("OBJECT", format));

        GenerationConfig<T> config = new GenerationConfig<>(schema);

        RequestDocument<T> reqDoc = new RequestDocument<>(
                List.of(new Contents(
                        List.of(new Part(content))
                )), config
        );

        return JsonProvider.gson().toJson(reqDoc);
    }
}
