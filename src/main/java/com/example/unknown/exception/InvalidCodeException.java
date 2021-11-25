package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class InvalidCodeException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidCodeException();

    private InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
