package com.example.unknown.global.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class InvalidMessageException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidMessageException();

    private InvalidMessageException() {
        super(ErrorCode.INVALID_MESSAGE);
    }
}
