package com.example.unknown.domain.Feed.presentation;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.presentation.dto.request.CreateFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.DeleteFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateDescriptionRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateTitleRequest;
import com.example.unknown.domain.Feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/create")
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        feedService.createFeed(request);
    }

    @GetMapping("/get")
    public List<Feed> get(){
    return feedService.getFeed();
    }

    @PutMapping("/updateTitle")
    public void updateTitle(@RequestBody @Valid UpdateTitleRequest request) {
        feedService.updateTitle(request);
    }

    @PutMapping("/updateDescription")
    public void updateDescription(@RequestBody @Valid UpdateDescriptionRequest request) {
        feedService.updateDescription(request);
    }

    @DeleteMapping("/delete")
    public void deleteFeed(@RequestBody @Valid DeleteFeedRequest request) {
        feedService.deleteFeed(request);
    }
}
