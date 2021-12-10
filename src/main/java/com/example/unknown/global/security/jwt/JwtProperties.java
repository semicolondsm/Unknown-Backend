package com.example.unknown.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Base64;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private final String secret;
    private final String header;
    private final String prefix;
    private final Long accessExp;
    private final Long refreshExp;

    public JwtProperties(String secret, Long accessExp, Long refreshExp,
                         String header, String prefix) {
        this.secret = Base64.getEncoder().encodeToString(secret.getBytes());
        this.accessExp = accessExp;
        this.refreshExp = refreshExp;
        this.header = header;
        this.prefix = prefix;
    }

}
