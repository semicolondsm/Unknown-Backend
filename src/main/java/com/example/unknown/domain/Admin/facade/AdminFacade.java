package com.example.unknown.domain.Admin.facade;

import com.example.unknown.domain.Admin.domain.Admin;
import com.example.unknown.domain.Admin.domain.repository.AdminRepository;
import com.example.unknown.domain.Admin.exception.AdminExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {

    private final AdminRepository adminRepository;

    public Admin getUserById(String email) {
        return adminRepository.findById(email).orElseThrow(() -> AdminExistsException.EXCEPTION);
    }

    public void isAlreadyExists(String email) {
        if (adminRepository.findById(email).isPresent()) {
            throw AdminExistsException.EXCEPTION;
        }
    }
}
