package com.example.dummyjson.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @SuppressWarnings("unchecked")
    @Test
    void testHealth() {
        Map<String, String> response = webTestClient.get()
                .uri("/health")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Map.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(response);
        assertEquals("UP", response.get("status"));
    }
}
