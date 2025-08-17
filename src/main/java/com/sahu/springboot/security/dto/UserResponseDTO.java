package com.sahu.springboot.security.dto;

import lombok.Builder;

@Builder
public record UserResponseDTO(
        Long userId,
        String username,
        String email
)
{
}
