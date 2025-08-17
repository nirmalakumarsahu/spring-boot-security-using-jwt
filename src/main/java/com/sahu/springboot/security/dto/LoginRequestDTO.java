package com.sahu.springboot.security.dto;

public record LoginRequestDTO(
        String username,
        String password
)
{
}
