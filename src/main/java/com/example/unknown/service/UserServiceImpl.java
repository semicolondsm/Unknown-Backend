package com.example.unknown.service;

import com.example.unknown.dto.request.UserRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.entity.auth.Role;
import com.example.unknown.entity.auth.User;
import com.example.unknown.entity.repository.auth.UserRepository;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public void signUp(UserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistsException.EXCEPTION;
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
}
