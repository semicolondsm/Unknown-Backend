package com.example.unknown.controller;

import com.example.unknown.dto.request.UserLoginRequest;
import com.example.unknown.dto.request.UserSignUpRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
