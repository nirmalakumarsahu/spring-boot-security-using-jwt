package com.sahu.springboot.security.dto;

public record LoginRequest(
        String username,
        String password
)
{
}
