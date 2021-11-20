package com.example.unknown.exception;

import com.example.unknown.global.error.ErrorCode;
import com.example.unknown.global.error.UnknownException;

public class InvalidPasswordException extends UnknownException {

    public static UnknownException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}
