package com.sahu.springboot.security.dto;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String username,
        String email
)
{
}
