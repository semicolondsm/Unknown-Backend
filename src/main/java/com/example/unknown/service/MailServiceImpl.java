package com.example.unknown.service;

import com.example.unknown.dto.request.SendEmailRequest;
import com.example.unknown.dto.request.VerifyCodeRequest;
import com.example.unknown.entity.Redis;
import com.example.unknown.entity.repository.RedisRepository;
import com.example.unknown.exception.InvalidCodeException;
import com.example.unknown.exception.SendMailFailedException;
import com.example.unknown.exception.UserNotExistsException;
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
    private static final Integer REDIS_TTL = 3 * 60;

    private static final StringBuilder key = new StringBuilder();
    private static final Random random = new Random();
    public static final String createKey = createKey();
    private final JavaMailSender mailSender;
    private final RedisRepository redisRepository;

    @Async
    public void sendEmail(SendEmailRequest request) {
        try {
            String code = createCode();

            MimeMessage mail = mailSender.createMimeMessage();
            mail.addRecipients(Message.RecipientType.TO, request.getEmail());
            mail.setFrom(request.getEmail());
            mail.setSubject("[Unknown] Email 인증 요청 메일입니다.");
            mail.setText("6자리 인증코드 : " + code);

            redisRepository.findById(request.getEmail())
                    .or(() -> Optional.of(new Redis(request.getEmail(), code, REDIS_TTL)))
                    .ifPresent(verifyCode -> redisRepository.save(verifyCode.changeCode(code, REDIS_TTL)));

            sendMail(mail);
        } catch (MessagingException e) {
            e.getStackTrace();
            throw SendMailFailedException.EXCEPTION;
        }
    }

    @Override
    public void verifyEmail(VerifyCodeRequest request) {

        Redis redis = redisRepository.findById(request.getEmail())
                .orElseThrow(() -> UserNotExistsException.EXCEPTION);

        if (!redis.getCode().equals(request.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }

        redisRepository.save(Redis.builder()
                .email(request.getEmail())
                .code("Email Verify")
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
