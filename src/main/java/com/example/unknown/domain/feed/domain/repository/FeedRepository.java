package com.example.unknown.domain.feed.domain.repository;

import com.example.unknown.domain.feed.domain.Feed;
import com.example.unknown.domain.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    Optional<Feed> findFeedById(Long Id);

    List<Feed> findById(User user);

    Page<Feed> findFeedById(boolean page, PageRequest range);
}
