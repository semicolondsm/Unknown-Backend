package com.example.unknown.entity.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LanguageRole {

    LANGUAGE_ROLE_C("C"),
    LANGUAGE_ROLE_Cpp("C++"),
    LANGUAGE_ROLE_JAVA("Java"),
    LANGUAGE_ROLE_JAVASCRIPT("JavaScript"),
    LANGUAGE_ROLE_TYPESCRIPT("TypeScript"),
    LANGUAGE_ROLE_GO("Go"),
    LANGUAGE_ROLE_SWIFT("Swift"),
    LANGUAGE_ROLE_KOTLIN("Kotlin"),
    ;


    private String language;

}
