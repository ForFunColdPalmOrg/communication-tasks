package com.dk.service.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    GENERAL_ERROR,
    INVALID_REQUEST;

    private final String defaultMessage;

    ErrorCode () { defaultMessage = "Default message was not provided yet"; }

    public String formattedDefaultMessage(Object... args) {return this.defaultMessage.formatted(args);}
}
