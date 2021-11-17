package com.example.unknown.entity.repository.user;

import com.example.unknown.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    
}
