package com.example.unknown.domain.mail.service;

import com.example.unknown.domain.admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.mail.domain.AuthCode;
import com.example.unknown.domain.mail.domain.repository.AuthCodeRepository;
import com.example.unknown.domain.mail.exception.SendMailFailedException;
import com.example.unknown.domain.mail.presentation.dto.request.SendEmailRequest;
import com.example.unknown.domain.user.facade.UserAuthCodeFacade;
import com.example.unknown.global.exception.InvalidCodeException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    private static final Integer REDIS_TTL = 5 * 60;

    private final UserAuthCodeFacade userAuthCodeFacade;
    private final JavaMailSender mailSender;
    private final AuthCodeRepository authCodeRepository;

    @Async
    public void sendEmail(SendEmailRequest request) {
        try {
            String code = createCode();

            MimeMessage mail = mailSender.createMimeMessage();
            mail.addRecipients(Message.RecipientType.TO, request.getEmail());
            mail.setFrom(request.getEmail());
            mail.setSubject("[Unknown] Email 인증 요청 메일입니다.");
            mail.setText("6자리 인증코드 : " + code);

            authCodeRepository.findById(request.getEmail())
                    .or(() -> Optional.of(new AuthCode(request.getEmail(), code, null, REDIS_TTL)))
                    .ifPresent(verifyCode -> authCodeRepository.save(verifyCode.updateAuthCode(request.getEmail(), code, null, REDIS_TTL)));

            sendMail(mail);
        } catch (MessagingException e) {
            e.getStackTrace();
            throw SendMailFailedException.EXCEPTION;
        }
    }

    @Override
    public void verifyEmail(VerifyCodeRequest request) {

        AuthCode authCode = userAuthCodeFacade.getAuthCodeById(request.getEmail());

        if (!authCode.getCode().equals(request.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }

        authCodeRepository.save(AuthCode.builder()
                .email(request.getEmail())
                .code(null)
                .message("Email Verify")
                .ttl(REDIS_TTL)
                .build());
    }

    private String createCode() {
        return RandomStringUtils.randomNumeric(6);
    }

    private void sendMail(MimeMessage mail) {
        mailSender.send(mail);
    }
}
