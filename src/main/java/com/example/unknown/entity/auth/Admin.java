package com.example.unknown.entity.auth;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_admin")
public class Admin implements UserDetails {

    @Id
    @Column()
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    private Admin(String id, String password, Role role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
