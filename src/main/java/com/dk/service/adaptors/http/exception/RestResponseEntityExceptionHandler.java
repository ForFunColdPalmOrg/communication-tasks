package com.dk.service.adaptors.http.exception;

import com.hj.oneserviceapp.service.exception.ErrorType;
import com.hj.oneserviceapp.service.exception.InternalSystemException;
import com.hj.oneserviceapp.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    private static final String EXP_LOG_TEMPLATE = "Exception response payload: {}";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException exception) {
        return buildInternalErrorResponse(ErrorType.INTERNAL, exception, HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<ApiErrorResponse> buildInternalErrorResponse(ErrorType type, InternalSystemException ex, HttpStatus status) {
        ApiError error = new ApiError(type, ex.getErrorCode(), ex.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(error));
        log.warn(EXP_LOG_TEMPLATE, error, ex);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }
}
