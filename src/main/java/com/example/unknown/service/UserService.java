package com.example.unknown.service;

import com.example.unknown.dto.request.UserLoginRequest;
import com.example.unknown.dto.request.UserSignUpRequest;
import com.example.unknown.dto.response.TokenResponse;

public interface UserService {

    void signUp(UserSignUpRequest request);

    TokenResponse login(UserLoginRequest request);
}
