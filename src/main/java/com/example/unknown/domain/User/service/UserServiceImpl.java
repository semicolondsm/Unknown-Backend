package com.example.unknown.domain.User.service;

import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.Mail.domain.AuthCode;
import com.example.unknown.domain.Mail.domain.repository.AuthCodeRepository;
import com.example.unknown.domain.Refresh_token.domain.repository.RefreshTokenRepository;
import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.domain.repository.UserRepository;
import com.example.unknown.domain.User.domain.types.Role;
import com.example.unknown.domain.User.facade.UserAuthCodeFacade;
import com.example.unknown.domain.User.facade.UserFacade;
import com.example.unknown.domain.User.presentation.dto.request.ChangePasswordRequest;
import com.example.unknown.domain.User.presentation.dto.request.UserLoginRequest;
import com.example.unknown.domain.User.presentation.dto.request.UserSignUpRequest;
import com.example.unknown.global.exception.*;
import com.example.unknown.global.security.jwt.JwtProperties;
import com.example.unknown.global.security.jwt.JwtTokenProvider;
import com.example.unknown.global.utils.token.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Integer REDIS_TTL = 5 * 60;

    private final UserFacade userFacade;
    private final UserAuthCodeFacade userAuthCodeFacade;
    private final UserRepository userRepository;
    private final AuthCodeRepository authCodeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;

    @Override
    public void signUp(UserSignUpRequest request) {

        userFacade.isAlreadyExists(request.getEmail());

        if (!userAuthCodeFacade.getAuthCodeById(request.getEmail()).getMessage().equals("Email Verify")) {
            throw InvalidMessageException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .githubId(request.getGithubId())
                .role(Role.ROLE_USER)
                .build());

        userAuthCodeFacade.AuthCodeDelete(request.getEmail());
    }

    @Override
    public TokenResponse login(UserLoginRequest request) {
        User user = userFacade.getByEmail(request.getEmail());

        if (!user.getRole().equals(Role.ROLE_USER)) {
            throw InvalidRoleException.EXCEPTION;
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return jwtTokenProvider.generateToken(request.getEmail());
    }

    public void verifyPassword(VerifyCodeRequest request) {

        AuthCode authCode = userAuthCodeFacade.getAuthCodeById(request.getEmail());

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

    @Transactional
    @Override
    public void changePassword(ChangePasswordRequest request) {

        if (!userAuthCodeFacade.getAuthCodeById(request.getEmail()).getMessage().equals("Password Verify")) {
            throw InvalidMessageException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getNewPassword()))
                .role(Role.ROLE_USER)
                .build());

        userAuthCodeFacade.AuthCodeDelete(request.getEmail());
    }

    @Override
    public TokenResponse tokenRefresh(String refreshToken) {
        jwtTokenProvider.isRefreshToken(refreshToken);

        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .map(token -> {
                    String accessToken = jwtTokenProvider.generateAccessToken(token.getEmail());
                    String newRefreshToken = jwtTokenProvider.generateRefreshToken(token.getEmail());
                    token.update(newRefreshToken, jwtProperties.getRefreshExp());
                    return new TokenResponse(accessToken, newRefreshToken);
                })
                .orElseThrow(() -> InvalidTokenException.EXCEPTION);
    }
}
