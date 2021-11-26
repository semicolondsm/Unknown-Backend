package com.example.unknown.service;

import com.example.unknown.dto.request.ChangePasswordRequest;
import com.example.unknown.dto.request.UserRequest;
import com.example.unknown.dto.request.VerifyCodeRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.entity.Redis;
import com.example.unknown.entity.auth.Role;
import com.example.unknown.entity.auth.User;
import com.example.unknown.entity.repository.RedisRepository;
import com.example.unknown.entity.repository.auth.UserRepository;
import com.example.unknown.exception.*;
import com.example.unknown.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Integer REDIS_TTL = 3 * 60;

    private final UserRepository userRepository;
    private final RedisRepository redisRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public void signUp(UserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }

        Redis redis = redisRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotVerificationException.EXCEPTION);

        if (!redis.getCode().equals("Email Verify")) {
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

        String access_token = jwtProvider.generateAccessToken(request.getEmail());
        String refresh_token = jwtProvider.generateRefreshToken(request.getEmail());

        return new TokenResponse(access_token, refresh_token);
    }

    @Override
    public void verifyPassword(VerifyCodeRequest request) {

        Redis redis = redisRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotVerificationException.EXCEPTION);

        if (!redis.getCode().equals(request.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }

        redisRepository.save(Redis.builder()
                .email(request.getEmail())
                .code("Password Verify")
                .ttl(REDIS_TTL)
                .build());
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {

        Redis redis = redisRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotVerificationException.EXCEPTION);

        if (!redis.getCode().equals("Password Verify")) {
            throw InvalidCodeException.EXCEPTION;
        }

        userRepository.findByEmail(request.getEmail())
                .map(user -> user.updatePassword(passwordEncoder.encode(request.getNewPassword())))
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);
    }
}
