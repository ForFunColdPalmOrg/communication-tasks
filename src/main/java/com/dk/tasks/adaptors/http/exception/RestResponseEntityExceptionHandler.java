package com.dk.tasks.adaptors.http.exception;

import com.dk.tasks.service.exception.ErrorType;
import com.dk.tasks.service.exception.ExternalSystemException;
import com.dk.tasks.service.exception.InternalSystemException;
import com.dk.tasks.service.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

import static com.dk.tasks.service.exception.ErrorCode.GENERAL_ERROR;
import static com.dk.tasks.service.exception.ErrorCode.INVALID_INPUT;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    private static final String EXP_LOG_TEMPLATE = "Exception response payload: {}, stacktrace: {}";

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiErrorResponse> handleException(Exception exception) {
        return buildErrorResponse(exception);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ApiErrorResponse> handleNullPointerException(NullPointerException exception) {
        return buildErrorResponse(exception);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException exception) {
        return buildInternalErrorResponse(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ExternalSystemException.class})
    public ResponseEntity<ApiErrorResponse> handleExternalSystemException(InternalSystemException exception) {
        return buildExternalErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({InternalSystemException.class})
    public ResponseEntity<ApiErrorResponse> handleInternalSystemException(InternalSystemException exception) {
        return buildInternalErrorResponse(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException exception) {
        return buildErrorResponse(exception);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        ApiError apiError = new ApiError(INVALID_INPUT, exception.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(apiError));
        log.warn(EXP_LOG_TEMPLATE, apiError, exception.getStackTrace(), exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TypeMismatchException.class})
    public ResponseEntity<Object> handleTypeMismatchException(TypeMismatchException exception) {
        ApiError apiError = new ApiError(INVALID_INPUT, exception.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(apiError));
        log.warn(EXP_LOG_TEMPLATE, apiError, exception.getStackTrace(), exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        ApiError apiError = new ApiError(INVALID_INPUT, exception.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(apiError));
        log.warn(EXP_LOG_TEMPLATE, apiError, exception.getStackTrace(), exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
        ApiError apiError = new ApiError(INVALID_INPUT, exception.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(apiError));
        log.warn(EXP_LOG_TEMPLATE, apiError, exception.getStackTrace(), exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<ApiError> apiErrors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiError(ErrorType.INTERNAL, INVALID_INPUT, "%s %s".formatted(error.getField(), error.getDefaultMessage())))
                .toList();
        ApiErrorResponse response = new ApiErrorResponse(apiErrors);
        log.warn(EXP_LOG_TEMPLATE, apiErrors, exception.getStackTrace(), exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private static ResponseEntity<ApiErrorResponse> buildExternalErrorResponse(InternalSystemException ex, HttpStatus status) {
        ApiError error = new ApiError(ErrorType.EXTERNAL, ex.getErrorCode(), ex.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(error));
        log.warn(EXP_LOG_TEMPLATE, error, ex.getStackTrace(), ex);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    private static ResponseEntity<ApiErrorResponse> buildInternalErrorResponse(InternalSystemException ex, HttpStatus status) {
        ApiError error = new ApiError(ErrorType.INTERNAL, ex.getErrorCode(), ex.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(error));
        log.warn(EXP_LOG_TEMPLATE, error, ex.getStackTrace(), ex);
        return new ResponseEntity<>(response, new HttpHeaders(), status);
    }

    private static ResponseEntity<ApiErrorResponse> buildErrorResponse(Exception ex) {
        ApiError error = new ApiError(ErrorType.INTERNAL, GENERAL_ERROR, ex.getMessage());
        ApiErrorResponse response = new ApiErrorResponse(List.of(error));
        log.warn(EXP_LOG_TEMPLATE, error, ex.getStackTrace(), ex);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
