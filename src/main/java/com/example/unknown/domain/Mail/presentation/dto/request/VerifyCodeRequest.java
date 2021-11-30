package com.example.unknown.domain.Mail.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class VerifyCodeRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String code;
}
