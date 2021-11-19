package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InvalidEnumException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidEnumException(HttpStatusResponseEntity.RESPONSE_ENUM_NOT_INVALID);

    public InvalidEnumException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_ENUM_NOT_INVALID);
    }
}
