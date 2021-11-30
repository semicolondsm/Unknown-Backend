package com.example.unknown.domain.User.service;

import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.User.domain.AuthCode;
import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.domain.repository.AuthCodeRepository;
import com.example.unknown.domain.User.domain.repository.UserRepository;
import com.example.unknown.domain.User.domain.types.Role;
import com.example.unknown.domain.User.exception.UserNotVerificationException;
import com.example.unknown.domain.User.presentation.dto.request.ChangePasswordRequest;
import com.example.unknown.domain.User.presentation.dto.request.UserRequest;
import com.example.unknown.global.exception.*;
import com.example.unknown.global.security.jwt.JwtTokenProvider;
import com.example.unknown.global.utils.token.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Integer REDIS_TTL = 5 * 60;

    private final UserRepository userRepository;
    private final AuthCodeRepository authCodeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void signUp(UserRequest request) {
        if (userRepository.findById(request.getEmail()).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }

        AuthCode authCode = authCodeRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotVerificationException.EXCEPTION);

        if (!authCode.getMessage().equals("Email Verify")) {
            throw InvalidCodeException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build());
    }

    @Override
    public TokenResponse login(UserRequest request) {
        User user = userRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);

        if (!user.getRole().equals(Role.ROLE_USER)) {
            throw InvalidRoleException.EXCEPTION;
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return jwtTokenProvider.generateToken(request.getEmail());
    }

    public void verifyPassword(VerifyCodeRequest request) {

        AuthCode authCode = authCodeRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotVerificationException.EXCEPTION);

        if (!authCode.getCode().equals(request.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }

        authCodeRepository.save(AuthCode.builder()
                .email(request.getEmail())
                .code(null)
                .message("Password Verify")
                .ttl(REDIS_TTL)
                .build());
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {

        AuthCode authCode = authCodeRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotVerificationException.EXCEPTION);

        if (!authCode.getMessage().equals("Password Verify")) {
            throw InvalidCodeException.EXCEPTION;
        }

        userRepository.findById(request.getEmail())
                .map(user -> user.updatePassword(passwordEncoder.encode(request.getNewPassword())))
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);
    }
}
