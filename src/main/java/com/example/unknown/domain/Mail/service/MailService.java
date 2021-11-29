package com.example.unknown.domain.Mail.service;

import com.example.unknown.domain.Mail.presentation.dto.request.SendEmailRequest;
import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;

public interface MailService {
    void sendEmail(SendEmailRequest request);

    void verifyEmail(VerifyCodeRequest request);
}
