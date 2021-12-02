package com.example.unknown.domain.comment.facade;

import com.example.unknown.domain.comment.domain.Comment;
import com.example.unknown.domain.comment.domain.repository.CommentRepository;
import com.example.unknown.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public void isAlreadyExists(Long id) {
        if (commentRepository.findById(id).isPresent()) {
            throw CommentNotFoundException.EXCEPTION;
        }
    }
}
