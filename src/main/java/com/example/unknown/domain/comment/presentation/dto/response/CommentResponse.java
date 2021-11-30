package com.example.unknown.domain.comment.presentation.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentResponse {

    private final Long id;
    private final String content;
    private final String createDate;
    private final String lastModifiedDate;

    public CommentResponse(Long id, String content, String createDate, String lastModifiedDate) {
        this.id = id;
        this.content = content;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;

    }
}

