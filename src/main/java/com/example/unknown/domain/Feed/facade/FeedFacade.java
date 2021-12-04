package com.example.unknown.domain.Feed.facade;

import com.example.unknown.domain.Feed.domain.Feed;
import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.Feed.exception.FeedNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedById(@NotBlank Long id) {

        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotExistsException.EXCEPTION);
    }

}
