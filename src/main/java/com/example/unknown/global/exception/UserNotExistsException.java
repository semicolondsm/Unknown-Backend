package com.example.unknown.global.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class UserNotExistsException extends CustomException {

    public static CustomException EXCEPTION =
            new UserNotExistsException();

    private UserNotExistsException() {
        super(ErrorCode.USER_NOT_EXISTS);
    }
}
