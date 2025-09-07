package com.sahu.springboot.security.service;

import com.sahu.springboot.security.dto.UserRequest;
import com.sahu.springboot.security.dto.UserResponse;

public interface UserService {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserResponse createUser(UserRequest userRequest);
}
