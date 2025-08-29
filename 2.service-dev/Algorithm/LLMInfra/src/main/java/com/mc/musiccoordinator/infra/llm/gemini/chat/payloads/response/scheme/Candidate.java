package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.scheme;

import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme.Content;

public record Candidate(Content content, String finishReason, double avgLogprobs) {
}
