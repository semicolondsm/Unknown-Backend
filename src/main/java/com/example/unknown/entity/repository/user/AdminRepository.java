package com.example.unknown.entity.repository.user;

import com.example.unknown.entity.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findById(String id);
}
