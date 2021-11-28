package com.example.unknown.entity.post;

import com.example.unknown.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_content")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Lob
    @Column(nullable = false, length = 60000)
    private String description;

    @Builder
    public Post(Long id, String title, String description) {
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
