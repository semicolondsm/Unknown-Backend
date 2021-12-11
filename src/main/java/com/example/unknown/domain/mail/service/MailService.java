package com.example.unknown.domain.mail.service;

import com.example.unknown.domain.mail.presentation.dto.request.SendEmailRequest;
import com.example.unknown.domain.admin.presentation.dto.request.VerifyCodeRequest;

public interface MailService {
    void sendEmail(SendEmailRequest request);

    void verifyEmail(VerifyCodeRequest request);
}
