package com.example.unknown.entity.content;

import com.example.unknown.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown-content")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 30)
    private String title;

    @Lob
    @Column(nullable = false, length=512)
    private String description;

    @Builder
    public Post (Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Post changeTitle(String title) {
        this.title = title;
        return this;
    }

    public Post changeDescription(String description) {
        this.description = description;
        return this;
    }



}
