package com.dk.tasks.service.exception;

public class DoubleException extends InternalSystemException {

    public DoubleException(ErrorCode errorCode, Object... args) {
        super(errorCode, errorCode.formattedDefaultMessage(args));
    }
}
