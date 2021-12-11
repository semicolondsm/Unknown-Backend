package com.example.unknown.domain.user.facade;

import com.example.unknown.domain.user.domain.User;
import com.example.unknown.domain.user.domain.repository.UserRepository;
import com.example.unknown.domain.user.exception.CertificateNotFoundException;
import com.example.unknown.global.exception.UserExistsException;
import com.example.unknown.global.exception.UserNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public String getEmail() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication.getPrincipal() == null)
            throw CertificateNotFoundException.EXCEPTION;

        return authentication.getName();
    }

    public User getByEmail(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);
    }

    public User getUser() {
        return userRepository.findById(getEmail())
                .orElseThrow(() -> CertificateNotFoundException.EXCEPTION);
    }

    public void isAlreadyExists(String email) {
        if (userRepository.findById(email).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }
    }
}
