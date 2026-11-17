package com.hcl2.jwtdemo.controller;

import com.hcl2.jwtdemo.dto.PostRequest;
import com.hcl2.jwtdemo.dto.PostResponse;
import com.hcl2.jwtdemo.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@Tag(name="Post APIs")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<PostResponse> all() {
        return postService.findAll();
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@Valid @RequestBody PostRequest req, Authentication auth) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postService.addPost(req, auth.getName()));
    }
}