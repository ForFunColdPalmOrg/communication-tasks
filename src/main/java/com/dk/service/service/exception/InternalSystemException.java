package com.dk.service.service.exception;

import lombok.Getter;


@Getter
public class InternalSystemException extends RuntimeException {
    public static final ErrorType ERROR_TYPE = ErrorType.INTERNAL;

    private final ErrorCode errorCode;

    public InternalSystemException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
