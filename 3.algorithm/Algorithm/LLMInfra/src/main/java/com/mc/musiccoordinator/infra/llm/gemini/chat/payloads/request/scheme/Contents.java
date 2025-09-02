package com.mc.musiccoordinator.infra.llm.gemini.chat.payloads.request.scheme;

import com.mc.musiccoordinator.infra.llm.gemini.chat.commons.Part;

import java.util.List;

public record Contents(List<Part> parts) {

}
