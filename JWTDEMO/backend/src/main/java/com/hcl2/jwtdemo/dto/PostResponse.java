package com.hcl2.jwtdemo.dto;

import com.hcl2.jwtdemo.entity.Post;

import java.time.LocalDateTime;

public record PostResponse(Long id, String title, String content, String author, LocalDateTime createdAt) {
    public static PostResponse from(Post p) {
        return new PostResponse(p.getId(), p.getTitle(), p.getContent(),
                p.getAuthor(), p.getCreatedAt());
    }
}
