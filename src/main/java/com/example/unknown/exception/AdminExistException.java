package com.example.unknown.exception;

import com.example.unknown.util.HttpStatusResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdminExistException extends CustomException {

    public static CustomException EXCEPTION =
            new AdminExistException(HttpStatusResponseEntity.RESPONSE_ADMIN_EXIST);

    public AdminExistException(ResponseEntity<HttpStatus> httpStatusResponseEntity) {
        super(HttpStatusResponseEntity.RESPONSE_ADMIN_EXIST);
    }
}
