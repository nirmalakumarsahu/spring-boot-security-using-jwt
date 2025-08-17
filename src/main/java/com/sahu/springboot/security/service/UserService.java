package com.sahu.springboot.security.service;

import com.sahu.springboot.security.dto.UserRequestDTO;
import com.sahu.springboot.security.model.User;

public interface UserService {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User addUser(UserRequestDTO userRequestDTO);
}
