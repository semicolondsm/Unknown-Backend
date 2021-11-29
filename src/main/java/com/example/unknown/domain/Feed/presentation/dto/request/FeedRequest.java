package com.example.unknown.domain.Feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class FeedRequest {


    @NotBlank
    private String title;

    @Lob
    private String description;


}
