package com.portal.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfiguration {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("Car Sales")
                .packagesToScan("com.portal.api.controller")
                .build();
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Car Sales")
                        .version("1.0.0")
                        .description("Microservice using Java, Spring Boot and Apache Kafka"));
    }
}
