package com.example.unknown.domain.feed.domain;

import com.example.unknown.domain.user.domain.User;
import com.example.unknown.global.domain.repository.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_content")
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createAt;
    private LocalDateTime modifyAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uesrId", nullable = false)
    private User userId;

    public Feed changeTitle(String title) {
        this.title = title;
        return this;
    }

    public Feed changeDescription(String description) {
        this.description = description;
        return this;
    }


}
