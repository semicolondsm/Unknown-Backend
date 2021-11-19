package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InvalidPasswordException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidPasswordException(HttpStatusResponseEntity.RESPONSE_INVALID_PASSWORD);

    public InvalidPasswordException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_INVALID_TOKEN);
    }
}
