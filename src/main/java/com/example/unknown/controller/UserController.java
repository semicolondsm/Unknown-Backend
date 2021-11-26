package com.example.unknown.controller;

import com.example.unknown.dto.request.ChangePasswordRequest;
import com.example.unknown.dto.request.SendEmailRequest;
import com.example.unknown.dto.request.UserRequest;
import com.example.unknown.dto.request.VerifyCodeRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.service.MailService;
import com.example.unknown.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final MailService mailService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest request) {
        userService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserRequest request) {
        return userService.login(request);
    }

    @PostMapping("/email")
    public void sendEmail(SendEmailRequest request) {
        mailService.sendEmail(request);
    }

    @PutMapping("/email/verify")
    public void verifyEmail(VerifyCodeRequest request) {
        mailService.verifyEmail(request);
    }

    @PutMapping("/password/verify")
    public void verifyPassword(VerifyCodeRequest request) {
        userService.verifyPassword(request);
    }

    @PutMapping("/password")
    public void changePassword(ChangePasswordRequest request) {
        userService.changePassword(request);
    }
}
