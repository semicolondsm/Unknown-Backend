package com.example.unknown.domain.Feed.domain.repository;

import com.example.unknown.domain.Feed.domain.Feed;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Integer> {

    Optional<Feed> findFeedById(Integer id);

    Page<Feed> findAllBySearchFeed(Pageable page);
}
