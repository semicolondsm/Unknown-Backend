package com.example.unknown.domain.admin.facade;

import com.example.unknown.domain.admin.domain.Admin;
import com.example.unknown.domain.admin.domain.repository.AdminRepository;
import com.example.unknown.domain.admin.exception.AdminExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {

    private final AdminRepository adminRepository;

    public Admin getUserById(String email) {
        return adminRepository.findById(email).orElseThrow(() -> AdminExistsException.EXCEPTION);
    }

}
