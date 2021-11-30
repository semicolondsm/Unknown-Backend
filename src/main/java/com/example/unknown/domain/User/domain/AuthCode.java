package com.example.unknown.domain.User.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@AllArgsConstructor
@RedisHash
public class AuthCode {

    @Id
    private String email;

    private String code;

    private String message;

    @TimeToLive
    private long ttl;

    @Builder
    public AuthCode(String email, String code, String message, Integer ttl) {
        this.email = email;
        this.code = code;
        this.message = message;
        this.ttl = ttl;
    }

    public AuthCode updateAuthCode(String email ,String code, long ttl) {
        this.email = email;
        this.code = code;
        this.ttl = ttl;
        return this;
    }

}

