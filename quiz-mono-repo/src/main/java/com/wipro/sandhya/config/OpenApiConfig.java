package com.wipro.sandhya.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // Global OpenAPI info
    @Bean
    public OpenAPI quizMonoRepoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Quiz Mono Repo API")
                        .description("API documentation for Quiz and Question Management System")
                        .version("1.0.0"));
    }

    // Group for Question-related endpoints
    @Bean
    public GroupedOpenApi questionsApi() {
        return GroupedOpenApi.builder()
                .group("questions")
                .packagesToScan("com.wipro.sandhya") // scan root package
                .pathsToMatch("/question/**") // matches QuestionController endpoints
                .build();
    }

    // Group for Quiz-related endpoints
    @Bean
    public GroupedOpenApi quizApi() {
        return GroupedOpenApi.builder()
                .group("quiz")
                .packagesToScan("com.wipro.sandhya")
                .pathsToMatch("/quiz/**") // matches QuizController endpoints
                .build();
    }
}
