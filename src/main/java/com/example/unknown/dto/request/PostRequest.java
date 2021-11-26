package com.example.unknown.dto.request;

import com.example.unknown.entity.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostRequest {
private Long id;
private String title;
private String description;

@Builder public PostRequest (Long id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
}

public Post toEntity() {
    return Post.builder().id(id).title(title).description(description).build();
}
}
