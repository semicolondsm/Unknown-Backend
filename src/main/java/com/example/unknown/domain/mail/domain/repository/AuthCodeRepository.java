package com.example.unknown.domain.mail.domain.repository;

import com.example.unknown.domain.mail.domain.AuthCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
