package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.facade.UserFacade;
import com.example.unknown.domain.comment.domain.Comment;
import com.example.unknown.domain.comment.domain.repository.CommentRepository;
import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.domain.comment.presentation.dto.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Override
    public CommentResponse postComment(CommentRequest request) {

        User user = userFacade.getUserById(request.getComment());

        commentRepository.save(
                Comment.builder()
                        .user(user)
                        .content(request.getComment())
                        .build()
        );

        return null;
    }



}
