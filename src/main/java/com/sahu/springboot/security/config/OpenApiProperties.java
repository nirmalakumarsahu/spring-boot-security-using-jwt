package com.sahu.springboot.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "openapi")
public class OpenApiProperties {
    private String title;
    private String description;
    private String version;
    private Contact contact;
    private List<Server> servers;
    private String securitySchemeName;
    private String scheme;
    private String bearerFormat;

    @Setter
    @Getter
    public static class Contact {
        private String name;
        private String email;
        private String url;
    }
    
    @Getter
    @Setter
    public static class Server {
        private String name;
        private String url;
        private String description;
    }
}


