package com.wipro.employemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI employeeManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management API")
                        .description("API documentation for Employee, Department, Project, and Salary services")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Sandhya")
                                .email("sandhyapandava2002@gmail.com")
                                .url("https://example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
