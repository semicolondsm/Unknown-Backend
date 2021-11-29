package com.example.unknown.domain.User.presentation;

import com.example.unknown.domain.User.presentation.dto.request.ChangePasswordRequest;
import com.example.unknown.domain.User.presentation.dto.request.UserRequest;
import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.User.service.UserService;
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
    public void signUp(@RequestBody @Valid UserRequest request) {
        userService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserRequest request) {
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
}
