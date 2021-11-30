package com.example.unknown.domain.Mail.domain.repository;

import com.example.unknown.domain.Mail.domain.AuthCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
