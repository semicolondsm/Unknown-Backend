package com.example.unknown.service;

import com.example.unknown.dto.request.AdminLoginRequest;
import com.example.unknown.dto.request.AdminSignUpRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.entity.repository.user.AdminRepository;
import com.example.unknown.entity.user.Admin;
import com.example.unknown.entity.user.Role;
import com.example.unknown.exception.AdminExistException;
import com.example.unknown.exception.AdminNotFoundException;
import com.example.unknown.exception.InvalidEnumException;
import com.example.unknown.exception.InvalidPasswordException;
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
    public void signUp(AdminSignUpRequest request) {
        if (adminRepository.findById(request.getId()).isPresent()) {
            throw AdminExistException.EXCEPTION;
        }

        adminRepository.save(Admin.builder()
                .id(request.getId())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_ADMIN)
                .build());
    }

    @Override
    public TokenResponse login(AdminLoginRequest request) {
        Admin admin = adminRepository.findById(request.getId())
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);

        if (!admin.getRole().equals(Role.ROLE_ADMIN)) {
            throw InvalidEnumException.EXCEPTION;
        }

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return new TokenResponse(jwtProvider.generateAccessToken(request.getId()));
    }
}
