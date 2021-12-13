package com.example.unknown.domain.comment.domain;

import com.example.unknown.domain.User.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


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

    private LocalDateTime commentCreateAt;
    private LocalDateTime commentModifyAt;


    @Builder
    public Comment(Long commentId, String content, User user, LocalDateTime commentCreateAt, LocalDateTime commentModifyAt) {
        this.commentId = commentId;
        this.user = user;
        this.comment = content;
        this.commentCreateAt = commentCreateAt;
        this.commentModifyAt = commentModifyAt;
    }

    public void modifyContent(String comment) {
        this.comment = comment;
    }


}
