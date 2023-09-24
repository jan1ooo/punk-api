package br.jan1ooo.punkapi.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("punk-api")
                .pathsToMatch("/api/beers/**", "/auth/**")
                .build();
    }
}
