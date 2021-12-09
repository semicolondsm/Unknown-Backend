package com.example.unknown.domain.User.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class RefreshTokenRequest {

    @NotBlank
    private String refresh_token;
}
