package com.example.unknown.domain.Feed.facade;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.Feed.exception.FeedNotExistsException;
import com.example.unknown.domain.Feed.presentation.dto.response.FeedResponse;
import com.example.unknown.domain.User.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedById(Long feedId) {
        return feedRepository.findFeedById(feedId)
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);
    }

    public FeedResponse feedToFeedResponse(Feed feed, User user) {

        return FeedResponse.builder()
                .title(feed.getTitle())
                .description(feed.getDescription())
                .build();
    }

    public FeedResponse feedResponse(Feed feed, User user){

        return FeedResponse.builder()
                .title(feed.getTitle())
                .description(feed.getDescription())
                .feedId(feed.getId())
                .build();
    }
}
