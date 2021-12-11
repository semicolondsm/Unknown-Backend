package com.example.unknown.domain.feed.presentation;

import com.example.unknown.domain.feed.presentation.dto.request.ModifyFeedRequest;
import com.example.unknown.domain.feed.presentation.dto.request.PostFeedRequest;
import com.example.unknown.domain.feed.presentation.dto.response.FeedResponse;
import com.example.unknown.domain.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void PostFeed (@RequestBody @Valid PostFeedRequest request) {
        feedService.PostFeed(request);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyFeed(@RequestBody @Valid ModifyFeedRequest request) {
        feedService.modifyFeed(request);
    }

    @DeleteMapping("/{feed_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFeed(@PathVariable(name = "feed_id") Long feedId) {

        feedService.removeFeed(feedId);
    }

    @GetMapping("/List")
    public List<FeedResponse> getFeed(@RequestParam("page")int page, @RequestParam("range") int range) {
        return feedService.getFeed(page, range);
    }

}