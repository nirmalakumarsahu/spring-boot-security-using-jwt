package com.sahu.springboot.security.security.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class CustomUserDetails extends User {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String email;
    private List<String> userRoles;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             Long userId, String email, List<String> userRoles)
    {
        super(username, password, authorities);
        this.userId = userId;
        this.email = email;
        this.userRoles = userRoles;
    }

}
