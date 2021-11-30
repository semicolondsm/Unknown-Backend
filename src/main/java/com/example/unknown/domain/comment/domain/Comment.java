package com.example.unknown.domain.comment.domain;

import com.example.unknown.domain.User.domain.User;
import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "unknown_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Comment(Long commentId, String content, User user) {
        this.commentId = commentId;
        this.user = user;
        this.comment = content;
    }

    public void editContent(String comment) {
        this.comment = comment;
    }


}
