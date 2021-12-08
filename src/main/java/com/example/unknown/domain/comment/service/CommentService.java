package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.comment.presentation.dto.request.PostCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.EditCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.RemoveCommentRequest;

public interface CommentService {

    void postComment(PostCommentRequest request);

    void editComment(EditCommentRequest request);

    void removeComment(RemoveCommentRequest request);

}
