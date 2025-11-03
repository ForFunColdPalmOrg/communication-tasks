package com.dk.service.service.exception;

import lombok.Getter;


@Getter
public class ExternalSystemException extends RuntimeException {
    public static final ErrorType ERROR_TYPE = ErrorType.EXTERNAL;

    private final ErrorCode errorCode;

    public ExternalSystemException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
