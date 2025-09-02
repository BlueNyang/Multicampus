package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.scheme;

import java.util.List;

public record UsageMetadata(
        int promptTokenCount,
        int candidatesTokenCount,
        int totalTokenCount,
        List<TokenDetails> promptTokensDetails,
        List<TokenDetails> candidatesTokensDetails) {
}
