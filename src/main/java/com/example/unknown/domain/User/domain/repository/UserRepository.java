package com.example.unknown.domain.User.domain.repository;

import com.example.unknown.domain.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
}
