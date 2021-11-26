package com.example.unknown.dto.response;

import com.example.unknown.entity.post.Post;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String description;

    public PostResponse (Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
    }
}
