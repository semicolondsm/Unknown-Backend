package com.example.unknown.domain.mail.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@AllArgsConstructor
@RedisHash
public class AuthCode {

    @Id
    private String email;

    private String code;

    private String message;

    @TimeToLive
    private long ttl;

    public AuthCode updateAuthCode(String email, String code, String message, long ttl) {
        this.email = email;
        this.code = code;
        this.message = message;
        this.ttl = ttl;
        return this;
    }

}

