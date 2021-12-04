package com.example.unknown.global.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class ApplicationNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new ApplicationNotFoundException();

    private ApplicationNotFoundException() {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
