package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.User.domain.User;
import com.example.unknown.domain.User.facade.UserFacade;
import com.example.unknown.domain.comment.domain.Comment;
import com.example.unknown.domain.comment.domain.repository.CommentRepository;
import com.example.unknown.domain.comment.facade.CommentFacade;
import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.EditCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.RemoveCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Override
    public void postComment(CommentRequest request) {

        User user = userFacade.getUser();

        commentRepository.save(
                Comment.builder()
                        .user(user)
                        .content(request.getComment())
                        .build()
        );

    }

    @Override
    public void editComment(EditCommentRequest request) {

        userFacade.isAlreadyExists(request.getComment());

        Comment comment = commentFacade.getCommentById(request.getCommentId());

        comment.editContent(request.getComment());

        commentRepository.save(comment);
    }

    @Override
    public void removeComment(RemoveCommentRequest request) {

        userFacade.isAlreadyExists(request.getComment());

        commentRepository.delete(commentFacade.getCommentById(request.getCommentId()));

    }

}
