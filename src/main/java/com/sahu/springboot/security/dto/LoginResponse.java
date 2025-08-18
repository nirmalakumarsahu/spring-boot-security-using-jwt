package com.sahu.springboot.security.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record LoginResponse(
      String token,
      String tokenType,
      Date expirationDate
)
{
}
