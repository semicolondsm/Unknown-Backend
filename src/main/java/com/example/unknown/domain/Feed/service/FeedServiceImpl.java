package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.Feed.facade.FeedFacade;
import com.example.unknown.domain.Feed.presentation.dto.request.CreateFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.DeleteFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateDescriptionRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.UpdateTitleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedServiceImpl implements FeedService {

    private final FeedFacade feedFacade;
    private final FeedRepository feedRepository;

    @Override
    public List<Feed> getFeed() {
        return feedRepository.findAll();
    }

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
    public void deleteFeed(DeleteFeedRequest request) {

        Feed feed = feedFacade.getFeedById(request.getId());

        feedRepository.delete(Feed.builder()
                .id(feed.getId())
                .build());
    }
}
