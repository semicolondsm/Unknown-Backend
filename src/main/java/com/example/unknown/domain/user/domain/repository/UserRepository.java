package com.example.unknown.domain.user.domain.repository;

import com.example.unknown.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
