package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class UserNotVerificationException extends CustomException {

    public static CustomException EXCEPTION =
            new UserNotVerificationException();

    private UserNotVerificationException() {
        super(ErrorCode.USER_NOT_VERIFICATION);
    }
}
