package com.example.unknown.exception;

import com.example.unknown.global.error.ErrorCode;
import com.example.unknown.global.error.UnknownException;

public class InvalidRoleException extends UnknownException {

    public static UnknownException EXCEPTION =
            new InvalidRoleException();

    private InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
