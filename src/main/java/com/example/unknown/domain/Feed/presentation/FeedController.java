package com.example.unknown.domain.Feed.presentation;

import com.example.unknown.domain.Feed.presentation.dto.request.CreateFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateDescriptionRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateTitleRequest;
import com.example.unknown.domain.Feed.presentation.dto.response.FeedResponse;
import com.example.unknown.domain.Feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        feedService.createFeed(request);
    }

    @GetMapping
    public FeedResponse getFeedList(Pageable pageable) {
        return (FeedResponse) feedService.getFeedList(pageable);
    }

    @PutMapping("/update/title")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTitle(@RequestBody @Valid UpdateTitleRequest request) {
        feedService.updateTitle(request);
    }

    @PutMapping("/update/description")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDescription(@RequestBody @Valid UpdateDescriptionRequest request) {
        feedService.updateDescription(request);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable Integer feedId) {
        feedService.deleteFeed(feedId);
    }
}

