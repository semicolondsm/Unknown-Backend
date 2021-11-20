package com.example.unknown.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnknownException.class)
    public ResponseEntity<ErrorResponse> handlingBusinessException(UnknownException e) {
        ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatusCode(), errorCode.getMessage()),
                HttpStatus.valueOf(errorCode.getStatusCode()));
    }
}
