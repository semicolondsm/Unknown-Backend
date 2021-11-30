package com.example.unknown.domain.Feed.domain.types;

import com.example.unknown.global.domain.repository.BaseTimeEntity;
import com.example.unknown.domain.User.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_content")
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(length = 30)
    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Feed changeTitle(String title) {
        this.title = title;
        return this;
    }

    public Feed changeDescription(String description) {
        this.description = description;
        return this;
    }


}
