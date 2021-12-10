package com.example.unknown.domain.User.service;

import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.User.presentation.dto.request.ChangePasswordRequest;
import com.example.unknown.domain.User.presentation.dto.request.RefreshTokenRequest;
import com.example.unknown.domain.User.presentation.dto.request.UserLoginRequest;
import com.example.unknown.domain.User.presentation.dto.request.UserSignUpRequest;
import com.example.unknown.global.utils.token.dto.TokenResponse;

public interface UserService {
    void signUp(UserSignUpRequest request);

    TokenResponse login(UserLoginRequest request);

    void verifyPassword(VerifyCodeRequest request);

    void changePassword(ChangePasswordRequest request);

    TokenResponse tokenRefresh(String refreshToken);
}
