package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.Feed.exception.FeedNotExistsException;
import com.example.unknown.domain.Feed.facade.FeedFacade;
import com.example.unknown.domain.Feed.presentation.dto.request.CreateFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateDescriptionRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateTitleRequest;
import com.example.unknown.domain.Feed.presentation.dto.response.DefaultResponse;
import com.example.unknown.domain.Feed.presentation.dto.response.FeedResponse;
import com.example.unknown.domain.comment.domain.repository.CommentRepository;
import com.example.unknown.domain.comment.service.CommentService;
import com.example.unknown.global.exception.ApplicationNotFoundException;
import com.example.unknown.global.security.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;

    private final FeedFacade feedFacade;


    @Override
    public void createFeed(CreateFeedRequest request) {

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build());
    }

    @Transactional
    @Override
    public void updateTitle(UpdateTitleRequest request) {

        Feed feed = feedFacade.getFeedById(request.getId());

        feedRepository.save(Feed.builder()
                .id(feed.getId())
                .title(request.getTitle())
                .build());
    }

    @Transactional
    @Override
    public void updateDescription(UpdateDescriptionRequest request) {

        Feed feed = feedFacade.getFeedById(request.getId());

        feedRepository.save(Feed.builder()
                .id(feed.getId())
                .description(request.getDescription())
                .build());
    }

    @Override
    public void deleteFeed(Integer feedId) {
        feedRepository.findFeedById(feedId)
                .orElseThrow(() -> ApplicationNotFoundException.EXCEPTION);

        Feed feed = feedRepository.findFeedById(feedId)
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);

        feedRepository.delete(feed);
    }

    @Override
    public DefaultResponse getFeedList(Pageable page) {
        Page<Feed> feeds = feedRepository.findAllBySearchFeed(page);
        return getFeedList(feeds);
    }

    @Override
    public void searchFeed(Integer feedId) {

        feedRepository.findFeedById(feedId)
                .map(feed -> feedRepository.save(feed.searchFeed()))
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);
    }
}
