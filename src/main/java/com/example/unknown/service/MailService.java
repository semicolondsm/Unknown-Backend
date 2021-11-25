package com.example.unknown.service;

import com.example.unknown.dto.request.SendEmailRequest;
import com.example.unknown.dto.request.VerifyCodeRequest;

public interface MailService {
    void sendEmail(SendEmailRequest request);

    void verifyEmail(VerifyCodeRequest request);
}
