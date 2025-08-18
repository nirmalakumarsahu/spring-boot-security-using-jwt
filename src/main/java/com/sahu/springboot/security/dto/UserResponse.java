package com.sahu.springboot.security.dto;

import lombok.Builder;

@Builder
public record UserResponse(
        Long userId,
        String username,
        String email
)
{
}
