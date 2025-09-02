package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.scheme;

public record ErrorScheme(int code,
                          String message,
                          String status) {
}
