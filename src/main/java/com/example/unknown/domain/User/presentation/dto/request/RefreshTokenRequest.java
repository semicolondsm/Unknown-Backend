package com.example.unknown.domain.User.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class RefreshTokenRequest {

    @NotBlank
    private String refreshToken;
}
