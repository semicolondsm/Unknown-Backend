package com.example.unknown.entity.jwt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refresh_token")
public class RefreshTokenEntity implements Serializable {

    @Id
    private  String email;

    private String refreshToken;

    @TimeToLive
    private Long refreshExp;
    public RefreshTokenEntity update(String token, Long ttl) {
        this.refreshToken = token;
        return this;
    }
}
