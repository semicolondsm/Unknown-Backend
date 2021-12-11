package com.example.unknown.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class RefreshTokenRequest {

    @NotBlank
    private String refreshToken;
}
