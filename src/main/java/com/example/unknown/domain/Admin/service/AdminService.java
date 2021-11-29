package com.example.unknown.domain.Admin.service;

import com.example.unknown.domain.Admin.presentation.dto.request.AdminRequest;
import com.example.unknown.global.utils.token.dto.TokenResponse;

public interface AdminService {

    void signUp(AdminRequest request);

    TokenResponse login(AdminRequest request);
}
