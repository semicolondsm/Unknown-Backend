package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.user.domain.User;
import com.example.unknown.domain.user.facade.UserFacade;
import com.example.unknown.domain.comment.domain.Comment;
import com.example.unknown.domain.comment.domain.repository.CommentRepository;
import com.example.unknown.domain.comment.facade.CommentFacade;
import com.example.unknown.domain.comment.presentation.dto.request.EditCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.PostCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.RemoveCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Override
    public void postComment(PostCommentRequest request) {

        User user = userFacade.getUser();

        commentRepository.save(
                Comment.builder()
                        .user(user)
                        .commentCreateAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .content(request.getComment())
                        .build()
        );

    }

    @Override
    public void modifyComment(EditCommentRequest request) {

        userFacade.isAlreadyExists(request.getComment());

        Comment comment = commentFacade.getCommentById(request.getCommentId());

        comment
                .modifyContent(request.getComment());

        commentRepository.save(
                Comment.builder()
                        .commentModifyAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")))
                        .build()
        );
    }

    @Override
    public void removeComment(RemoveCommentRequest request) {

        userFacade.isAlreadyExists(request.getComment());

        commentRepository.delete(commentFacade.getCommentById(request.getCommentId()));

    }

}
