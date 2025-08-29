package com.mc.musiccoordinator.infra.llm.exception;

public enum ErrorCode {
    INVALID_API_KEY("LM4001", "Invalid API Key"),
    BAD_REQUEST("LM4000", "Bad Request"),
    INTERNAL_SERVER_ERROR("LM5000", "Internal Server Error"),
    INVALID_ARGUMENT("LM4002", "Invalid Argument"),
    ;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
