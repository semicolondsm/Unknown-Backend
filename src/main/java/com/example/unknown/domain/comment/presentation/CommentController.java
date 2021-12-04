package com.example.unknown.domain.comment.presentation;

import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/commment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void postComment(@RequestBody @Valid CommentRequest request) {

        commentService.postComment(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editComment(@RequestBody @Valid CommentRequest request) {

        commentService.editComment(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeComment(@RequestBody @Valid CommentRequest request) {

        commentService.removeComment(request);
    }

}
