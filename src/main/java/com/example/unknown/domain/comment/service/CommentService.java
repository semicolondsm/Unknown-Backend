package com.example.unknown.domain.comment.service;

import com.example.unknown.domain.comment.domain.Comment;
import com.example.unknown.domain.comment.presentation.dto.request.EditCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.PostCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.RemoveCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {

    void postComment(PostCommentRequest request);

    void modifyComment(EditCommentRequest request);

    void removeComment(RemoveCommentRequest request);

}
