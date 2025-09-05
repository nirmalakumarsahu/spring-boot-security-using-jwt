package com.sahu.springboot.security.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthConstants {
    public final String LOGIN_URL = "/api/v1/auth/login";
    public final String REGISTRATION_URL = "/api/v1/auth/register";
    public final String USER_DASHBOARD_URL = "/api/v1/dashboard/user";
    public final String ADMIN_DASHBOARD_URL = "/api/v1/dashboard/admin";

    public final String ROLE_USER = "USER";
    public final String ROLE_ADMIN = "ADMIN";
    public final String ROLE_PREFIX = "ROLE_";

    public final String HEADER_AUTHORIZATION = "Authorization";
    public final String TOKEN_TYPE_BEARER = "Bearer ";

    public final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**", "/swagger-ui/**", "/documentation/**", "/api-docs/**"
    };
}
