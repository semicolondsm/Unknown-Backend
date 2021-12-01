package com.example.unknown.domain.Feed.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class CreateFeedRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
