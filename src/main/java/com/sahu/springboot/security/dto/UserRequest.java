package com.sahu.springboot.security.dto;

public record UserRequest(
        String username,
        String email,
        String password
)
{
}
