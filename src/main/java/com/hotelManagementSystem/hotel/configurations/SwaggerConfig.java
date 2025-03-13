package com.hotelManagementSystem.hotel.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI swaggerConfigurations() {
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Bearer Authentication")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
        SecurityRequirement bearerAuthentication = new SecurityRequirement()
                .addList("Bearer Authentication");
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Bearer Authentication", securityScheme))
                .addSecurityItem(bearerAuthentication)
                .info(new Info()
                        .title("Hotel Management API")
                        .version("v1.0.0")
                        .description("Api Request For Testing With Swagger ")
                );

    }
}
