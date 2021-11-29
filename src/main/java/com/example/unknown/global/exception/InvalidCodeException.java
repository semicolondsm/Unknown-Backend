package com.example.unknown.global.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class InvalidCodeException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidCodeException();

    private InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
