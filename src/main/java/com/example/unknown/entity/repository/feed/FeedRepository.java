package com.example.unknown.entity.repository.feed;

import com.example.unknown.entity.post.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedRepository extends JpaRepository<Feed, Long> {

    Optional<Feed> findById(Long Id);
}
