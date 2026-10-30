package com.hcl2.jwtdemo.controller;

import com.hcl2.jwtdemo.dto.AuthRequest;
import com.hcl2.jwtdemo.entity.Post;
import com.hcl2.jwtdemo.repository.PostRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@AllArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping
    public List<Post> all(){
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public Post create(@Valid @RequestBody Post req,
                       Authentication auth){
        return postRepository.save(new Post(req.getTitle(), req.getContent(), auth.getName()));
    }
}
