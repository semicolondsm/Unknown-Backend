package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;

public interface CommentService {

    void postComment(CommentRequest request);

}
