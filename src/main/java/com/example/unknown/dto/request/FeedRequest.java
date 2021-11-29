package com.example.unknown.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class FeedRequest {

    @NotEmpty
    private String title;

    @Lob
    private String description;

    @NotEmpty
    private String author;
}
