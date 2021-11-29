package com.example.unknown.domain.Mail.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class SendEmailRequest {

    @Email
    @NotBlank
    private String email;
}
