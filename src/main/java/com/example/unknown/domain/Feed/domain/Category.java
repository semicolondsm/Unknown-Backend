package com.example.unknown.domain.Feed.domain;

import com.example.unknown.domain.Feed.domain.types.LanguageRole;
import com.example.unknown.domain.Feed.domain.types.SubjectRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "unknown_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageRole language;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SubjectRole subject;

}