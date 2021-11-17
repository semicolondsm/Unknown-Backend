package com.example.unknown.entity.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@AllArgsConstructor
@RedisHash
public class RefreshTokenEntity {

    @Id
    private final String email;

    private String token;

    @TimeToLive
    private Long ttl;

    public RefreshTokenEntity update(String token, Long ttl) {
        this.token = token;
        this.ttl = ttl;
        return this;
    }
}
