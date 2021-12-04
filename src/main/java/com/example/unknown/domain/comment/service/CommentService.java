package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;

public interface CommentService {

    void postComment(Integer feedId, CommentRequest request);

    Integer editComment(Integer commentId, CommentRequest request);

    void removeComment(Integer commentId, CommentRequest request);

}
