package com.example.unknown.service;

import com.example.unknown.dto.request.PostRequest;
import com.example.unknown.entity.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private static final PostRepository postRepository = null;

    public static Long save(PostRequest postRequest) {
        assert false;
        return postRepository.save(postRequest.toEntity()).getId();
    }
}
