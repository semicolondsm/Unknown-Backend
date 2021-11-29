package com.example.unknown.domain.Mail.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class SendMailFailedException extends CustomException {

    public static CustomException EXCEPTION =
            new SendMailFailedException();

    private SendMailFailedException() {
        super(ErrorCode.SEND_FAILED_MAIL);
    }
}
