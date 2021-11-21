package com.example.unknown.service;

import com.example.unknown.dto.request.AdminRequest;
import com.example.unknown.dto.response.TokenResponse;

public interface AdminService {

    void signUp(AdminRequest request);

    TokenResponse login(AdminRequest request);
}
