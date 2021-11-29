package com.example.unknown.domain.User.domain.repository;

import com.example.unknown.domain.User.domain.AuthCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
