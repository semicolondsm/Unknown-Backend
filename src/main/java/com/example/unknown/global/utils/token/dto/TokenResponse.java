package com.example.unknown.global.utils.token.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private String access_token;
    private String refresh_token;
}
