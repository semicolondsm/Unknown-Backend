package com.example.unknown.global.security.jwt;

import com.example.unknown.domain.refresh_token.domain.RefreshToken;
import com.example.unknown.domain.refresh_token.domain.repository.RefreshTokenRepository;
import com.example.unknown.global.exception.InvalidTokenException;
import com.example.unknown.global.security.auth.AuthUserDetailsService;
import com.example.unknown.global.utils.token.dto.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthUserDetailsService authUserDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;


    public String generateAccessToken(String email) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .claim("type", "access")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExp() * 1000))
                .compact();
    }

    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .setHeaderParam("typ", "JWT")
                .setSubject(email)
                .claim("type", "refresh")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExp() * 1000))
                .compact();
    }

    public TokenResponse generateToken(String id) {
        String accessToken = generateAccessToken(id);
        String refreshToken = generateRefreshToken(id);

        refreshTokenRepository.save(RefreshToken.builder()
                .email(id)
                .refreshToken(refreshToken)
                .refreshExp(jwtProperties.getRefreshExp() * 1000)
                .build());

        return new TokenResponse(accessToken, refreshToken);
    }

    public void isRefreshToken(String token) {
        if (!getTokenBody(token).get("type").equals("refresh")) {
            throw InvalidTokenException.EXCEPTION;
        }

    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader(jwtProperties.getHeader());
        if (bearer != null && bearer.length() > 7 && bearer.startsWith(jwtProperties.getPrefix())) {
            return bearer.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        return getTokenBody(token)
                .getExpiration().after(new Date());
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authUserDetailsService
                .loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(getSecretKey())
                .parseClaimsJws(token).getBody();
    }

    private String getTokenSubject(String token) {
        return getTokenBody(token).getSubject();
    }

    private String getSecretKey() {
        return Base64.getEncoder().encodeToString(jwtProperties.getSecret().getBytes());
    }

}
