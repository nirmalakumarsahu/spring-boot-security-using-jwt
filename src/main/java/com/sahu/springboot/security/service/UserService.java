package com.sahu.springboot.security.service;

import com.sahu.springboot.security.dto.UserRequest;
import com.sahu.springboot.security.model.User;

public interface UserService {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User addUser(UserRequest userRequest);
}
