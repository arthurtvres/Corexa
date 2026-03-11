package com.personal.personalapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Personal Trainer API")
                        .version("1.0.0")
                        .description("API RESTful para gerenciamento de usuários, treinos, exercícios e dietas de personal trainers")
                        .contact(new Contact()
                                .name("Personal Trainer API")
                                .email("contato@personaltrainer.com")));
    }
}

