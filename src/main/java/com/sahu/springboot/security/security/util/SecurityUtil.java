package com.sahu.springboot.security.security.util;

import com.sahu.springboot.security.security.dto.CustomUserDetails;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class SecurityUtil {

    public CustomUserDetails getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication() != null
                ? (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                : null;
    }

}
