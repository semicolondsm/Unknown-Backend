package com.example.unknown.domain.comment.presentation;

import com.example.unknown.domain.comment.presentation.dto.request.PostCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.EditCommentRequest;
import com.example.unknown.domain.comment.presentation.dto.request.RemoveCommentRequest;
import com.example.unknown.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postComment(@RequestBody @Valid PostCommentRequest request) {

        commentService.postComment(request);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyComment(@RequestBody @Valid EditCommentRequest request) {

        commentService.modifyComment(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeComment(@RequestBody @Valid RemoveCommentRequest request) {

        commentService.removeComment(request);
    }
}
