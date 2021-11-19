package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserExistException extends CustomException {

    public static CustomException EXCEPTION =
            new UserExistException(HttpStatusResponseEntity.RESPONSE_USER_EXIST);

    public UserExistException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_USER_EXIST);
    }

}
