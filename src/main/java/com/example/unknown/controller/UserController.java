package com.example.unknown.controller;

import com.example.unknown.dto.request.ChangePasswordRequest;
import com.example.unknown.dto.request.UserRequest;
import com.example.unknown.dto.response.TokenResponse;
import com.example.unknown.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserRequest request) {
        userService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserRequest request) {
        return userService.login(request);
    }

    @PutMapping("/password")
    public void changePassword(ChangePasswordRequest request) {
        userService.changePassword(request);
    }
}
