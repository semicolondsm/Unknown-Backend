package com.example.unknown.service;

import com.example.unknown.dto.request.AdminLoginRequest;
import com.example.unknown.dto.request.AdminSignUpRequest;
import com.example.unknown.dto.response.TokenResponse;

public interface AdminService {

    void signUp(AdminSignUpRequest request);

    TokenResponse login(AdminLoginRequest request);
}
