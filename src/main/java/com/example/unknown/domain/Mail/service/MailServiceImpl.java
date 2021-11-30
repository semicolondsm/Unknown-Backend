package com.example.unknown.domain.Mail.service;

import com.example.unknown.domain.Admin.presentation.dto.request.VerifyCodeRequest;
import com.example.unknown.domain.Mail.exception.SendMailFailedException;
import com.example.unknown.domain.Mail.presentation.dto.request.SendEmailRequest;
import com.example.unknown.domain.User.domain.AuthCode;
import com.example.unknown.domain.User.domain.repository.AuthCodeRepository;
import com.example.unknown.global.exception.InvalidCodeException;
import com.example.unknown.global.exception.UserNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {

    private static final Integer CODE_LENGTH = 6;
    private static final Integer REDIS_TTL = 5 * 60;

    private static final StringBuilder key = new StringBuilder();
    private static final Random random = new Random();
    public static final String createKey = createKey();
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
                    .ifPresent(verifyCode -> authCodeRepository.save(verifyCode.updateAuthCode(request.getEmail(), code, REDIS_TTL)));

            sendMail(mail);
        } catch (MessagingException e) {
            e.getStackTrace();
            throw SendMailFailedException.EXCEPTION;
        }
    }

    @Override
    public void verifyEmail(VerifyCodeRequest request) {

        AuthCode authCode = authCodeRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);

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

    private static String createKey() {
        key.setLength(0);

        for (int i = 0; i < CODE_LENGTH; i++) {
            key.append((random.nextInt(10)));
        }
        return key.toString();
    }

    private String createCode() {
        return MailServiceImpl.createKey.substring(0, 3) + "-" + MailServiceImpl.createKey.substring(3, 6);
    }

    private void sendMail(MimeMessage mail) {
        mailSender.send(mail);
    }
}
