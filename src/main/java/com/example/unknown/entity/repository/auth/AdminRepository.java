package com.example.unknown.entity.repository.auth;


import com.example.unknown.entity.auth.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
