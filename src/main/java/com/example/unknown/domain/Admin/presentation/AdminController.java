package com.example.unknown.domain.Admin.presentation;

import com.example.unknown.domain.Admin.presentation.dto.request.AdminRequest;
import com.example.unknown.domain.Admin.service.AdminService;
import com.example.unknown.global.utils.token.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AdminRequest request) {
        return adminService.login(request);
    }
}
