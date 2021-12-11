package com.example.unknown.domain.user.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class UserNotVerificationException extends CustomException {

    public static CustomException EXCEPTION =
            new UserNotVerificationException();

    private UserNotVerificationException() {
        super(ErrorCode.USER_NOT_VERIFICATION);
    }
}
