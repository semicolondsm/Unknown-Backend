package com.example.unknown.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_PASSWORD(400, "Invalid Password"),
    ;

    private int statusCode;
    private String message;
}
