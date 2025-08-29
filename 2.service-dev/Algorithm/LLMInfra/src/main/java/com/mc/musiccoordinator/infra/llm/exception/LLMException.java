package com.mc.musiccoordinator.infra.llm.exception;

import com.mc.musiccoordinator.infra.llm.exception.ErrorCode;

/**
 * @Author: USER
 * @Date: 2025.08.29
 * @Description: LLM 관련 예외 처리 클래스
 */
public class LLMException extends RuntimeException {
    private final ErrorCode errorCode;

    public LLMException(ErrorCode errorCode) {
        super(errorCode.message());
        this.errorCode = errorCode;
    }

    public LLMException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.message(), cause);
        this.errorCode = errorCode;
    }

    public LLMException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public LLMException(String statusString, String message) {
        super(message);
        var errorCode = switch (statusString) {
            case "INVALID_API_KEY" -> ErrorCode.INVALID_API_KEY;
            case "BAD_REQUEST" -> ErrorCode.BAD_REQUEST;
            case "INTERNAL_SERVER_ERROR" -> ErrorCode.INTERNAL_SERVER_ERROR;
            case "INVALID_ARGUMENT" -> ErrorCode.INVALID_ARGUMENT;
            default -> ErrorCode.INTERNAL_SERVER_ERROR;
        };
        this.errorCode = errorCode;
    }

    public ErrorCode code() {
        return errorCode;
    }
}
