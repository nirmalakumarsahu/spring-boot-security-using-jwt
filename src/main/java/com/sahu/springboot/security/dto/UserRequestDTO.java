package com.sahu.springboot.security.dto;

public record UserRequestDTO(
        String username,
        String email,
        String password
)
{
}
