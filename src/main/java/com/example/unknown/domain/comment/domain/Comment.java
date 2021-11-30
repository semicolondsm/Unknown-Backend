package com.example.unknown.domain.comment.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown-comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Lob
    @Column(columnDefinition="TEXT")
    private String comment;



}
