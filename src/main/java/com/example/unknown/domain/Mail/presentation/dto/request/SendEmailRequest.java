package com.example.unknown.domain.Mail.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SendEmailRequest {

    @Email
    @NotBlank
    private String email;
}
