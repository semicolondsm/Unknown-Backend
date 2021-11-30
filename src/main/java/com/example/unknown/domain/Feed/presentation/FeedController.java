package com.example.unknown.domain.Feed.presentation;

import com.example.unknown.domain.Feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;
}
