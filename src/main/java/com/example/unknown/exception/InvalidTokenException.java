package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class InvalidTokenException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
