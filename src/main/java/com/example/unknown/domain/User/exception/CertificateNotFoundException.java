package com.example.unknown.domain.User.exception;

import com.example.unknown.global.error.exception.CustomException;
import com.example.unknown.global.error.exception.ErrorCode;

public class CertificateNotFoundException extends CustomException {

    public static CustomException EXCEPTION =
            new CertificateNotFoundException();

    public CertificateNotFoundException() {
        super(ErrorCode.CERTIFICATE_NOT_FOUND);
    }
}
