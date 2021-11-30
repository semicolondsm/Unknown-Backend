package com.example.unknown.domain.User.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    @Length(min = 6, max = 36)
    private String email;

    @NotBlank
    @Length(min = 8, max = 25)
    private String password;
}
