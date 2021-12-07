package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.presentation.dto.request.ModifyFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.PostFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.response.FeedResponse;

import java.util.List;

public interface FeedService {

    void PostFeed(PostFeedRequest request);

    void modifyFeed(ModifyFeedRequest request);

    void removeFeed(Long id);

    List<FeedResponse> getFeed(int page, int range);

}