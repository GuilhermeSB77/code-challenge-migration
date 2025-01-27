package com.example.dummyjson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    public static final String BASE_URL = "https://dummyjson.com";

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().baseUrl(BASE_URL);
    }

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.build();
    }

}