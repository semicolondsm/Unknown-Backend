package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.domain.comment.presentation.dto.response.CommentResponse;

public interface CommentService {

    CommentResponse postComment(CommentRequest request);

}
