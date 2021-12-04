package com.example.unknown.domain.comment.domain.repository;

import com.example.unknown.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByFeed(Integer feedId);
}
