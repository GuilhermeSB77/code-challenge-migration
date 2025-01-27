package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testGetAllProducts() {
        List<Product> products = webTestClient.get()
                .uri("/api/products")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Product.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(products);
        assertTrue(!products.isEmpty());
    }

    @Test
    void testGetProductById() {
        Product product = webTestClient.get()
                .uri("/api/products/{id}", 1)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Product.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(product);
        assertTrue(product.getId() == 1);
    }
}