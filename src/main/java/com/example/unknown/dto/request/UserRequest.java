package com.example.unknown.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    @Length()
    private String email;

    @NotBlank
    @Length(min = 8, max = 25)
    private String password;
}
