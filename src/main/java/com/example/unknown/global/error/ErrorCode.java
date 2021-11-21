package com.example.unknown.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(403, "Invalid Token"),
    INVALID_PASSWORD(400, "Invalid Password"),
    INVALID_ROLE(400, "Invalid Role"),
    USER_NOT_EXISTS(404, "User Not Exists"),
    USER_EXISTS(400, "User Exists"),
    ;

    private int statusCode;
    private String message;
}
