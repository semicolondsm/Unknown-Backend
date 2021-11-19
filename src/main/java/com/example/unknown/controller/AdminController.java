package com.example.unknown.controller;

import com.example.unknown.dto.request.AdminLoginRequest;
import com.example.unknown.dto.request.AdminSignUpRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.service.AdminService;
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

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid AdminSignUpRequest request) {
        adminService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AdminLoginRequest request) {
        return adminService.login(request);
    }
}
