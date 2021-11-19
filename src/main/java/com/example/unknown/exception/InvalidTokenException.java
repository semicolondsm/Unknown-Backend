package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InvalidTokenException extends CustomException {

    public InvalidTokenException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_INVALID_TOKEN);
    }
}
