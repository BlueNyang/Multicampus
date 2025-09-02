package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request;

import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme.Contents;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme.GenerationConfig;

import java.util.List;

public record RequestDocument<T>(
        List<Contents> contents,
        GenerationConfig<T> generationConfig) {
}
