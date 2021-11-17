package com.example.unknown.entity.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown-user")
public class User {

    @Id
    @Column(unique = false)
    private String name;

    @Column(unique = false)
    private String password;

    @Column(length = 20)
    private String email;

    @Column(length = 20)
    private Role role;

    @Builder
    private User(String name, String password, String email) {
        this.email = email;
        this.name = name;
        this.password = password;
    }




}
