package com.example.unknown.domain.category.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknwon_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languge;

    private Long parentId;

    @Builder
    public Category(String languge, Long parentId) {
        this.languge = languge;
        this.parentId = this.parentId;
    }
}
