package com.example.unknown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash
@AllArgsConstructor
public class Redis {

    @Id
    private String email;

    private String code;

    @TimeToLive
    private Integer ttl;

    public Redis changeCode(String code, Integer ttl) {
        this.code = code;
        this.ttl = ttl;
        return this;
    }

}
