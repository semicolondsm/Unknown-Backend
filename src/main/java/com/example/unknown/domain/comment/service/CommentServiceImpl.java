package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.Feed.domain.repository.FeedRepository;
import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.facade.UserFacade;
import com.example.unknown.domain.comment.domain.Comment;
import com.example.unknown.domain.comment.domain.repository.CommentRepository;
import com.example.unknown.domain.comment.exception.CommentNotFoundException;
import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.global.exception.ApplicationNotFoundException;
import com.example.unknown.global.security.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final AuthenticationFacade authenticationFacade;

    private final FeedRepository feedRepository;

    @Override
    public void postComment(Integer feedId, CommentRequest request) {

        User user = userFacade.getUserById(request.getContent());

        feedRepository.findById(feedId)
                .orElseThrow(() -> ApplicationNotFoundException.EXCEPTION);

        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .commentId(feedId)
                        .createdAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .updateAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .build()

        );
    }

    @Override
    public Integer editComment(Integer commentId, CommentRequest request) {
        return null;
    }

    @Override
    public void removeComment(Integer commentId, CommentRequest request) {

    }
}
