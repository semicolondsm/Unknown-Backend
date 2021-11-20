package com.example.unknown.service;

import com.example.unknown.dto.request.UserRequest;
import com.example.unknown.dto.response.TokenResponse;

public interface UserService {
    void signUp(UserRequest request);

    TokenResponse login(UserRequest request);
}
