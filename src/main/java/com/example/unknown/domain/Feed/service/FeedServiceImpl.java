package com.example.unknown.domain.Feed.service;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.Feed.exception.FeedNotExistsException;
import com.example.unknown.domain.Feed.facade.FeedFacade;
import com.example.unknown.domain.Feed.presentation.dto.request.ModifyFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.request.PostFeedRequest;
import com.example.unknown.domain.Feed.presentation.dto.response.FeedResponse;
import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.domain.repository.UserRepository;
import com.example.unknown.domain.User.exception.UserNotFoundException;
import com.example.unknown.domain.User.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedServiceImpl implements FeedService {

    private final UserRepository userRepository;
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Override
    public void PostFeed(PostFeedRequest request) {

        userFacade.isAlreadyExists(userFacade.getEmail());

        feedRepository.save(
                Feed.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .createAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .build()
        );
    }

    @Override
    public void modifyFeed(ModifyFeedRequest request) {
        userFacade.isAlreadyExists(userFacade.getEmail());

        Feed feed = feedFacade.getFeedById(request.getFeedId());

        feed
                .changeTitle(request.getTitle())
                .changeDescription(request.getDescription());

        feedRepository.save(
                Feed.builder()
                        .modifyAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .build()
        );

    }

    @Override
    public void removeFeed(Long id) {
        userRepository.findById(userFacade.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        feedRepository.findById(id)
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);

        feedRepository.deleteById(id);
    }

    @Override
    public List<FeedResponse> getFeed(int page, int range) {
        userFacade.isAlreadyExists(userFacade.getEmail());

        return feedRepository.findFeedById(true, PageRequest.of(page, range, Sort.by("id").descending()))
                .stream()
                .map(feed -> {
                    FeedResponse response = FeedResponse.builder()
                            .feedId(feed.getId())
                            .title(feed.getTitle())
                            .description(feed.getDescription())
                            .build();
                    return response;
                }).collect(Collectors.toList());
    }

    @Override
    public FeedResponse getOneFeed(Long feedId) {

        User user = userRepository.findById(userFacade.getEmail())
                .orElse(null);

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);

        return feedFacade.feedToFeedResponse(feed, user);
    }

    @Override
    public boolean closeFeed(Long feedId) {

        User user = userRepository.findById(userFacade.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);


        return false;
    }

}
