package com.example.unknown.domain.Feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DefaultResponse {

    private final Long id;
    private final String tittle;
}
