package com.example.unknown.domain.Mail.presentation;

import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.Mail.presentation.dto.request.SendEmailRequest;
import com.example.unknown.domain.Mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class MailController {

    private final MailService mailService;

    @PostMapping()
    public void sendEmail(@RequestBody @Valid SendEmailRequest request) {
        mailService.sendEmail(request);
    }

    @PutMapping("/verify")
    public void verifyEmail(@RequestBody @Valid VerifyCodeRequest request) {
        mailService.verifyEmail(request);
    }

}
