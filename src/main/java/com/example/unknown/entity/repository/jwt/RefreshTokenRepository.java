package com.example.unknown.entity.repository.jwt;

import com.example.unknown.entity.jwt.RefreshTokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, String> {
}
