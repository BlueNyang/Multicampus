package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response;

import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.scheme.Candidate;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.scheme.ErrorScheme;
import com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.response.scheme.UsageMetadata;

import java.util.List;

public record ResponseDocument(List<Candidate> candidates,
                               UsageMetadata usageMetadata,
                               String modelVersion,
                               String responseId,
                               String responseType,
                               ErrorScheme error) {
}
