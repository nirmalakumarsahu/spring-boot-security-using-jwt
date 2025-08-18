package com.sahu.springboot.security.service.impl;

import com.sahu.springboot.security.constant.AuthConstants;
import com.sahu.springboot.security.dto.UserRequest;
import com.sahu.springboot.security.model.User;
import com.sahu.springboot.security.repository.RoleRepository;
import com.sahu.springboot.security.repository.UserRepository;
import com.sahu.springboot.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User addUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleRepository.findByName(AuthConstants.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not found: USER"))));
        user.setIsActive(true);
        return userRepository.save(user);
    }

}
