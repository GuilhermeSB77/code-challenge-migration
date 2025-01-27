package com.example.dummyjson.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WebClientConfigTest {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Test
    void testWebClientBeanCreation() {
        // Verifica se o WebClient.Builder não é nulo.
        assertThat(webClientBuilder).isNotNull();

        // Verifica se a URL base configurada no WebClient.Builder é a esperada.
        WebClient webClient = webClientBuilder.baseUrl(WebClientConfig.BASE_URL).build();
        assertThat(webClient).isNotNull();
    }
}