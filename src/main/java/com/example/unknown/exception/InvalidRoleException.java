package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class InvalidRoleException extends CustomException {

    public static CustomException EXCEPTION =
            new InvalidRoleException();

    private InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
