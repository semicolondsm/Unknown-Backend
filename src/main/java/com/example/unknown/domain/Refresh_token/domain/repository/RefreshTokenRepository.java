package com.example.unknown.domain.Refresh_token.domain.repository;

import com.example.unknown.domain.Refresh_token.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
}
