package com.sahu.springboot.security.service.impl;

import com.sahu.springboot.security.constant.AuthConstants;
import com.sahu.springboot.security.model.Role;
import com.sahu.springboot.security.repository.UserRepository;
import com.sahu.springboot.security.security.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Loading user by username: {}", username);
        return userRepository.findByUsername(username).map(user -> {

            List<String> userRoles = user.getRoles().stream().map(Role::getName).toList();
            List<GrantedAuthority> authorities = userRoles.stream().map(role -> new SimpleGrantedAuthority(AuthConstants.ROLE_PREFIX + role))
                    .collect(Collectors.toList());

            return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities, user.getId(), user.getEmail(), userRoles);
        }).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

}
