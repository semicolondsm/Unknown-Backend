package com.example.unknown.domain.Feed.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class UpdateTitleRequest {

    @NotBlank
    private Long id;

    @NotBlank
    private String title;
}