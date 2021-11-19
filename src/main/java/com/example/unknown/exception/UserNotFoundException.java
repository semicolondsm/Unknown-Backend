package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new UserNotFoundException(HttpStatusResponseEntity.RESPONSE_USER_NOT_FOUND);

    public UserNotFoundException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_USER_NOT_FOUND);
    }

}
