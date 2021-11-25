package com.example.unknown.service;

import com.example.unknown.dto.request.SendEmailRequest;

public interface MailService {
    void sendEmail(SendEmailRequest request);
}
