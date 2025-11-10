package com.dk.tasks.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    GENERAL_ERROR,
    INVALID_REQUEST,
    INVALID_INPUT,
    TASK_DOUBLE("For client with tax_code %s, or phone %s, already exists task")
    ;

    private final String defaultMessage;

    ErrorCode () { defaultMessage = "Default message was not provided yet"; }

    public String formattedDefaultMessage(Object... args) {return this.defaultMessage.formatted(args);}
}
