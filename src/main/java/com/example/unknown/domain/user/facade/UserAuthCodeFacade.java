package com.example.unknown.domain.user.facade;

import com.example.unknown.domain.mail.domain.AuthCode;
import com.example.unknown.domain.mail.domain.repository.AuthCodeRepository;
import com.example.unknown.domain.user.exception.UserNotVerificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthCodeFacade {

    private final AuthCodeRepository authCodeRepository;

    public AuthCode getAuthCodeById(String email) {
        return authCodeRepository.findById(email).orElseThrow(() -> UserNotVerificationException.EXCEPTION);
    }

    public void AuthCodeDelete(String email) {
        authCodeRepository.deleteById(email);
    }
}
