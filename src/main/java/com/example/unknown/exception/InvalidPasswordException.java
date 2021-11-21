package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class InvalidPasswordException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
