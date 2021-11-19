package com.example.unknown.service;

import com.example.unknown.dto.request.UserLoginRequest;
import com.example.unknown.dto.request.UserSignUpRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.entity.repository.user.UserRepository;
import com.example.unknown.entity.user.Role;
import com.example.unknown.entity.user.User;
import com.example.unknown.exception.InvalidEnumException;
import com.example.unknown.exception.InvalidPasswordException;
import com.example.unknown.exception.UserExistException;
import com.example.unknown.exception.UserNotFoundException;
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
    public void signUp(UserSignUpRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build());
    }

    @Override
    public TokenResponse login(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!user.getRole().equals(Role.ROLE_USER)) {
            throw InvalidEnumException.EXCEPTION;
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return new TokenResponse(jwtProvider.generateAccessToken(request.getEmail()));
    }
}
