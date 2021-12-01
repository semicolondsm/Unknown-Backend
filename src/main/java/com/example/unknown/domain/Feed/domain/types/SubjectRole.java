package com.example.unknown.domain.Feed.domain.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubjectRole {

    SUBJECT_ROLE_BACKEND("BackEnd"),
    SUBJECT_ROLE_FRONTEND("FrontEnd"),
    SUBJECT_ROLE_IOS("iOS"),
    SUBJECT_ROLE_ANDROID("Android"),
    SUBJECT_ROLE_DESIGN("Design"),
    SUBJECT_ROLE_SECURITY("Security"),
    ;

    private String subject;
}
