package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final String BASE_URL = "https://dummyjson.com/products";

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Product> getAllProducts() {
        WebClient webClient = webClientBuilder.baseUrl(BASE_URL).build();
        Product[] products = webClient.get()
                .retrieve()
                .bodyToMono(Product[].class)
                .block();
        return Arrays.asList(products);
    }

    public Product getProductById(Long id) {
        WebClient webClient = webClientBuilder.baseUrl(BASE_URL).build();
        String url = BASE_URL + "/" + id;
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}