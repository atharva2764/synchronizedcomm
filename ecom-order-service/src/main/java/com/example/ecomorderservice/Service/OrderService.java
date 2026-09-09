package com.example.ecomorderservice.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String placeOrder(String productId) {


        String response = restTemplate.getForObject(
                "http://localhost:8081/product/" + productId,
                String.class
        );
        return response.equals("IN STOCK") ? "ORDER PLACED" : "NOT PLACED";

    }
}
