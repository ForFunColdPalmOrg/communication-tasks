package com.dk.service.service.exception;

public class NotFoundException extends InternalSystemException {

    public NotFoundException(ErrorCode errorCode, Object... args) {
        super(errorCode, errorCode.formattedDefaultMessage(args));
    }
}
