package com.example.unknown.exception;

import com.example.unknown.global.error.ErrorCode;
import com.example.unknown.global.error.UnknownException;

public class UserExistsException extends UnknownException {

    public static UnknownException EXCEPTION =
            new UserExistsException();

    private UserExistsException() {
        super(ErrorCode.UESR_EIXSTS);
    }
}
