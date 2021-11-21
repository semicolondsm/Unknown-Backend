package com.example.unknown.service;

import com.example.unknown.dto.request.AdminRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.entity.auth.Admin;
import com.example.unknown.entity.auth.Role;
import com.example.unknown.entity.repository.auth.AdminRepository;
import com.example.unknown.exception.InvalidPasswordException;
import com.example.unknown.exception.InvalidRoleException;
import com.example.unknown.exception.UserExistsException;
import com.example.unknown.exception.UserNotExistsException;
import com.example.unknown.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public void signUp(AdminRequest request) {
        if (adminRepository.findById(request.getId()).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }

        adminRepository.save(Admin.builder()
                .id(request.getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_ADMIN)
                .build());
    }

    @Override
    public TokenResponse login(AdminRequest request) {

        Admin admin = adminRepository.findById(request.getId())
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);

        if (!admin.getRole().equals(Role.ROLE_ADMIN)) {
            throw InvalidRoleException.EXCEPTION;
        }

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        String access_token = jwtProvider.generateAccessToken(request.getId());
        String refresh_token = jwtProvider.generateRefreshToken(request.getId());

        return new TokenResponse(access_token, refresh_token);
    }
}
