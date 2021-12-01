package com.example.unknown.domain.User.facade;

import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.domain.repository.UserRepository;
import com.example.unknown.global.exception.UserExistsException;
import com.example.unknown.global.exception.UserNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getUserById(String email) {
        return userRepository.findById(email).orElseThrow(() -> UserNotExistsException.EXCEPTION);
    }

    public void isAlreadyExists(String email) {
        if (userRepository.findById(email).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }
    }
}
