package com.example.unknown.domain.user.presentation;

import com.example.unknown.domain.admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.user.presentation.dto.request.ChangePasswordRequest;
import com.example.unknown.domain.user.presentation.dto.request.UserLoginRequest;
import com.example.unknown.domain.user.presentation.dto.request.UserSignUpRequest;
import com.example.unknown.domain.user.service.UserService;
import com.example.unknown.global.utils.token.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request) {
        return userService.login(request);
    }

    @PutMapping("/password/verify")
    public void verifyPassword(@RequestBody @Valid VerifyCodeRequest request) {
        userService.verifyPassword(request);
    }

    @PutMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        userService.changePassword(request);
    }

    @PutMapping("/refresh")
    public TokenResponse tokenRefresh(@RequestHeader("refresh_token") String refreshToken) {
        return userService.tokenRefresh(refreshToken);
    }
}
