package com.example.unknown.controller;

import com.example.unknown.dto.request.PostRequest;
import com.example.unknown.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creatPost(@RequestBody PostRequest postRequest) {
        postService.createNewPost(postRequest);
    }

}
