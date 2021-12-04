package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.presentation.dto.request.CreateFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateDescriptionRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateTitleRequest;
import com.example.unknown.domain.Feed.presentation.dto.response.DefaultResponse;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface FeedService {

    void createFeed(CreateFeedRequest request);

    void updateTitle(UpdateTitleRequest request);

    void updateDescription(UpdateDescriptionRequest request);

    void deleteFeed(Integer feedId);

    DefaultResponse getFeedList(Pageable page);

    void searchFeed(Integer feedId);

}
