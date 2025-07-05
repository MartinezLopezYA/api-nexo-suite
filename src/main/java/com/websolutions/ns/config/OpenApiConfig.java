package com.websolutions.ns.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("nexo-suite-v1")
                .pathsToMatch("/nexo-suite/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Nexo Suite API")
                        .description("Nexo Suit Documentation")
                        .version("1.0")
                        .contact(new Contact()
                                .name("WS - Developer Team")
                                .email("martinezlopezyersonandres.ing@gmail.com")))
                .addServersItem(new Server()
                        .url("http://localhost:5055/api")
                        .description("Local server"));
    }

}