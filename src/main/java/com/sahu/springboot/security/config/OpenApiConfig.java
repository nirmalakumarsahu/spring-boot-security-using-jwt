package com.sahu.springboot.security.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final OpenApiProperties openApiProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(openApiProperties.getTitle())
                        .description(openApiProperties.getDescription())
                        .version(openApiProperties.getVersion())
                        .contact(new Contact()
                                .name(openApiProperties.getContact().getName())
                                .email(openApiProperties.getContact().getEmail())
                                .url(openApiProperties.getContact().getUrl())
                        )
                )
                .servers(openApiProperties.getServers().stream().map(
                                server -> new Server().url(server.getUrl()).description(server.getDescription())
                        ).toList()
                )
                .addSecurityItem(new SecurityRequirement().addList(openApiProperties.getSecuritySchemeName()))
                .components(new Components()
                        .addSecuritySchemes(openApiProperties.getSecuritySchemeName(),
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme(openApiProperties.getScheme())
                                        .bearerFormat(openApiProperties.getBearerFormat())
                        )
                );
    }

}
