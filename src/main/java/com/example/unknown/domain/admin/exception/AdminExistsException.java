package com.example.unknown.domain.admin.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class AdminExistsException extends CustomException {

    public static CustomException EXCEPTION =
            new AdminExistsException();

    private AdminExistsException() {
        super(ErrorCode.ADMIN_EXISTS);
    }
}
