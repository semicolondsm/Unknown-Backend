package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class CustomException extends RuntimeException{

    private final HttpStatusResponseEntity httpStatusResponseEntity;

    public CustomException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        this.httpStatusResponseEntity = httpStatusResponseEntity;
    }
}
