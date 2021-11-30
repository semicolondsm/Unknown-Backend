package com.example.unknown.domain.comment.presentation;

import com.example.unknown.domain.comment.presentation.dto.request.CommentRequest;
import com.example.unknown.domain.comment.presentation.dto.response.CommentResponse;
import com.example.unknown.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feeds")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public CommentResponse postComment(@RequestBody CommentRequest request) {
       return commentService.postComment(request);
    }

}
