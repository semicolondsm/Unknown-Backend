package com.example.unknown.domain.Feed.presentation;

import com.example.unknown.domain.Feed.presentation.dto.request.PostRequest;
import com.example.unknown.domain.Feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {

    private final FeedService feedService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void PostFeed (PostRequest request) {
        feedService.PostFeed(request);
    }
}