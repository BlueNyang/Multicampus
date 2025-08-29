package com.mc.musiccoordinator.infra.llm;

import java.util.List;
import java.util.Map;

public interface BaseResponse {
    List<Map<String, Object>> messageToMap();

    boolean errorExists();

    String getErrorStatus();

    String getErrorMessage();
}
