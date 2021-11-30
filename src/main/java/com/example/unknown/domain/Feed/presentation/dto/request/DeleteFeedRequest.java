package com.example.unknown.domain.Feed.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class DeleteFeedRequest {

    @NotBlank
    public String title;

    @NotBlank
    public String description;
}
