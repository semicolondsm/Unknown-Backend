package com.example.unknown.domain.admin.service;

import com.example.unknown.domain.admin.presentation.dto.request.AdminRequest;
import com.example.unknown.global.utils.token.dto.TokenResponse;

public interface AdminService {

    TokenResponse login(AdminRequest request);
}
