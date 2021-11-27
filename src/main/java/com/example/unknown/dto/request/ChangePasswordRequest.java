package com.example.unknown.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class ChangePasswordRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String newPassword;
}
