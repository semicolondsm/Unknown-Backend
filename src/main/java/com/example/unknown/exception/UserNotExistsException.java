package com.example.unknown.exception;

import com.example.unknown.global.error.ErrorCode;
import com.example.unknown.global.error.UnknownException;

public class UserNotExistsException extends UnknownException {

    public static UnknownException EXCEPTION =
            new UserNotExistsException();

    private UserNotExistsException() {
        super(ErrorCode.USER_NOT_EXISTS);
    }
}
