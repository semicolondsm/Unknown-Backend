package com.example.unknown.domain.Feed.domain.repository;

import com.example.unknown.domain.Feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
