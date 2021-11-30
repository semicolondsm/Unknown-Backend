package com.example.unknown.domain.Admin.service;

import com.example.unknown.domain.Admin.domain.Admin;
import com.example.unknown.domain.Admin.exception.AdminExistsException;
import com.example.unknown.domain.Admin.facade.AdminFacade;
import com.example.unknown.domain.Admin.presentation.dto.request.AdminRequest;
import com.example.unknown.domain.Admin.domain.repository.AdminRepository;
import com.example.unknown.domain.User.domain.types.Role;
import com.example.unknown.global.exception.InvalidPasswordException;
import com.example.unknown.global.exception.InvalidRoleException;
import com.example.unknown.global.security.jwt.JwtTokenProvider;
import com.example.unknown.global.utils.token.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminFacade adminFacade;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void signUp(AdminRequest request) {
        if (adminFacade.isAlreadyExists(request.getId())) {
            throw AdminExistsException.EXCEPTION;
        }

        adminRepository.save(Admin.builder()
                .id(request.getId())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_ADMIN)
                .build());
    }

    @Override
    public TokenResponse login(AdminRequest request) {

        Admin admin = adminFacade.getUserById(request.getId());

        if (!admin.getRole().equals(Role.ROLE_ADMIN)) {
            throw InvalidRoleException.EXCEPTION;
        }

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return jwtTokenProvider.generateToken(request.getId());
    }
}
