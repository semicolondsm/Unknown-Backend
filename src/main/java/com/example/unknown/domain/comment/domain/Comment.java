package com.example.unknown.domain.comment.domain;

import com.example.unknown.domain.User.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @Builder
    public Comment(Long commentId, String content, User user) {
        this.commentId = commentId;
        this.user = user;
        this.content= content;
    }

    public void editContent(String content) {
        this.content = content;
        this.updateAt = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }


}
