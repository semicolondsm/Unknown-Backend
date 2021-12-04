package com.example.unknown.domain.Feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class FeedResponse {

    private Long id;
    private String title;
    private String description;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'hh:mm:ss")
    private LocalDateTime createdTime;
    private LocalDateTime modifiTime;

}
