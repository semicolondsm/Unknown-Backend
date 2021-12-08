package com.example.unknown.domain.User.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
