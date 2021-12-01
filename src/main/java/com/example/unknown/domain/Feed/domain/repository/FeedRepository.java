package com.example.unknown.domain.Feed.domain.repository;

import com.example.unknown.domain.Feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
