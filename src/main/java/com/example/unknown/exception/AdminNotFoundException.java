package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdminNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new AdminNotFoundException(HttpStatusResponseEntity.RESPONSE_ADMIN_NOT_FOUND);

    public AdminNotFoundException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_ADMIN_NOT_FOUND);
    }
}
