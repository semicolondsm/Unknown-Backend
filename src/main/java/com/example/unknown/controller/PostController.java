package com.example.unknown.controller;

import com.example.unknown.dto.request.PostRequest;
import com.example.unknown.dto.response.PostResponse;
import com.example.unknown.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {

    private PostController postService;

    @PostMapping("/post")
    public Long save(@RequestBody PostRequest postRequest) {
        return PostService.save(postRequest);
    }

    @PutMapping("/put/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        return postService.update(id, postRequest);
    }

    @GetMapping("/get/{id}")
    public PostResponse findById (@PathVariable Long id) {
        return postService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public PostResponse deleteById(@PathVariable Long id) {
    return postService.deleteById(id);
}

    public void setPostService(PostController postService) {
        this.postService = postService;
    }
}