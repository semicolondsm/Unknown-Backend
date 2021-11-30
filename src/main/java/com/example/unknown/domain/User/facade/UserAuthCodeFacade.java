package com.example.unknown.domain.User.facade;

import com.example.unknown.domain.User.domain.AuthCode;
import com.example.unknown.domain.User.domain.repository.AuthCodeRepository;
import com.example.unknown.domain.User.exception.UserNotVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthCodeFacade {

    private final AuthCodeRepository authCodeRepository;

    public AuthCode getAuthCodeById(String email) {
        return authCodeRepository.findById(email).orElseThrow(() -> UserNotVerificationException.EXCEPTION);
    }
}
