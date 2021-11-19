package com.example.unknown.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpStatusResponseEntity {

    public static final ResponseEntity<HttpStatus> RESPONSE_ENUM_NOT_INVALID = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ADMIN_NOT_FOUND = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ADMIN_EXIST = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_INVALID_PASSWORD = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_USER_NOT_FOUND = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_USER_EXIST = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
