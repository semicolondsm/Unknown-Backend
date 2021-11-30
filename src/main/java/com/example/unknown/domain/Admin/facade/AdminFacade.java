package com.example.unknown.domain.Admin.facade;

import com.example.unknown.domain.Admin.domain.Admin;
import com.example.unknown.domain.Admin.exception.AdminExistsException;
import com.example.unknown.domain.Feed.domain.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {

    private final AdminRepository adminRepository;

    public Admin getUserById(String email) {
        return adminRepository.findById(email).orElseThrow(() -> AdminExistsException.EXCEPTION);
    }

    public boolean isAlreadyExists(String email) {
        return adminRepository.findById(email).isEmpty();
    }
}
