package com.example.unknown.domain.Feed.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeedResponse {

    private Long feedId;
    private String title;
    private String description;
    private List<FeedResponse> feedResponseList = new ArrayList<>();

    @Builder
    public FeedResponse(List<FeedResponse> feedResponses) {
        this.feedResponseList = feedResponses;
    }
    
}
