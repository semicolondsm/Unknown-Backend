package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.EditCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.RemoveCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.response.CommentResponse;

public interface CommentService {

    void postComment(CommentRequest request);

    void editComment(EditCommentRequest request);

    void removeComment(RemoveCommentRequest request);

}
