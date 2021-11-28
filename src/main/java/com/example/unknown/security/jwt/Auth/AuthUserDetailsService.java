package com.example.unknown.security.jwt.Auth;

import com.example.unknown.entity.repository.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)  throws UsernameNotFoundException {
       return userRepository.findByEmail(email)
               .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

    }
}
    