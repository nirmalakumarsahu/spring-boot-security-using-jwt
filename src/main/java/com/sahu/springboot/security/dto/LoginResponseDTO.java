package com.sahu.springboot.security.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record LoginResponseDTO(
      String token,
      String tokenType,
      Date expirationDate
)
{
}
