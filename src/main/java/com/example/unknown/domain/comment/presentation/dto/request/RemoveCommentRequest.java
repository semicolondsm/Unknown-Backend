package com.example.unknown.domain.comment.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RemoveCommentRequest {

    private long comment_id;
    private String comment;
}
