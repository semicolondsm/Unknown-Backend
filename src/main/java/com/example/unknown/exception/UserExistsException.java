package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class UserExistsException extends CustomException {

    public static CustomException EXCEPTION =
            new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.USER_EXISTS);
    }
}
