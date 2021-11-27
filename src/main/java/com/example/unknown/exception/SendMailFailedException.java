package com.example.unknown.exception;

import com.example.unknown.global.error.CustomException;
import com.example.unknown.global.error.ErrorCode;

public class SendMailFailedException extends CustomException {

    public static CustomException EXCEPTION =
            new SendMailFailedException();

    private SendMailFailedException() {
        super(ErrorCode.SEND_FAILED_MAIL);
    }
}
