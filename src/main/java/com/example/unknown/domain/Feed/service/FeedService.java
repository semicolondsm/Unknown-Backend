package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.presentation.dto.request.CreateFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.DeleteFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateDescriptionRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateTitleRequest;

import java.util.List;

public interface FeedService {

    List<Feed> getFeed();

    void createFeed(CreateFeedRequest request);

    void updateTitle(UpdateTitleRequest request);

    void updateDescription(UpdateDescriptionRequest request);

    void deleteFeed(DeleteFeedRequest request);
}
