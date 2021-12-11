package com.example.unknown.domain.feed.facade;

import com.example.unknown.domain.feed.domain.Feed;
import com.example.unknown.domain.feed.domain.repository.FeedRepository;
import com.example.unknown.domain.feed.exception.FeedNotExistsException;
import com.example.unknown.domain.feed.presentation.dto.response.FeedResponse;
import com.example.unknown.domain.user.domain.User;
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
}
