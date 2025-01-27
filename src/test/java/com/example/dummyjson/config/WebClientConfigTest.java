package com.example.dummyjson.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testWebClientBuilderBean() {
        WebClient.Builder webClientBuilder = context.getBean(WebClient.Builder.class);
        assertNotNull(webClientBuilder, "The WebClient.Builder bean should be present in the context.");
    }

    @Test
    public void testWebClientBean() {
        WebClient webClient = context.getBean(WebClient.class);
        assertNotNull(webClient, "The WebClient bean should be present in the context.");
    }
}