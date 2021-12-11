package com.example.unknown.domain.admin.domain.repository;


import com.example.unknown.domain.admin.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
