package com.example.unknown.domain.Refresh_token.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refresh_token")
public class RefreshToken implements Serializable {

    @Id
    private  String email;

    private String refreshToken;

    @TimeToLive
    private Long refreshExp;
    public RefreshToken update(String token, Long ttl) {
        this.refreshToken = token;
        return this;
    }
}
