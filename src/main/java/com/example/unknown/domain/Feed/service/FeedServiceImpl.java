package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.Feed.exception.FeedNotExistsException;
import com.example.unknown.domain.Feed.facade.FeedFacade;
import com.example.unknown.domain.Feed.presentation.dto.request.ModifyFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.PostFeedRequest;
import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.domain.repository.UserRepository;
import com.example.unknown.domain.User.exception.UserNotFoundException;
import com.example.unknown.domain.User.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeedServiceImpl implements FeedService {

    private final UserRepository userRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Override
    public void PostFeed(PostFeedRequest request) {

        User user = userFacade.getUser();

        Feed feed = feedRepository.save(
                        Feed.builder()
                                .title(request.getTitle())
                                .description(request.getDescription())
                                .build()
        );
    }

    @Override
    public void modifyFeed(ModifyFeedRequest request) {
        User user = userFacade.getUser();

        Feed feed = feedFacade.getFeedById(request.getFeedId());

        feed
                .changeTitle(request.getTitle())
                .changeDescription(request.getDescription());
    }

    @Override
    public void removeFeed(Long id) {
        User user = userRepository.findById(userFacade.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        Feed feed = feedRepository.findById(id)
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);

        feedRepository.deleteById(id);
    }
}
