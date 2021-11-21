package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class UserNotExistsException extends CustomException {

    public static CustomException EXCEPTION =
            new UserNotExistsException();

    private UserNotExistsException() {
        super(ErrorCode.USER_NOT_EXISTS);
    }
}
