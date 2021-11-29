package com.example.unknown.entity.post;

import com.example.unknown.entity.BaseTimeEntity;
import com.example.unknown.entity.auth.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_content")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 30)
    private String title;

    @Lob
    @Column(nullable = false, length = 60000)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Post changeTitle(String title) {
        this.title = title;
        return this;
    }

    public Post changeDescription(String description) {
        this.description = description;
        return this;
    }


}
