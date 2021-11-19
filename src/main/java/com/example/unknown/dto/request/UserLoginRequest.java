package com.example.unknown.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UserLoginRequest {

    @Email
    @NotBlank
    @Length(min = 1, max = 36)
    private String email;

    @NotBlank
    @Length(min = 1, max = 20)
    private String password;
}
