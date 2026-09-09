package com.example.ecomorderservice.Service;

import com.example.ecomorderservice.dto.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final RestClient restClient;

    public OrderService(RestTemplate restTemplate, RestClient restClient) {
        this.restTemplate = restTemplate;
        this.restClient = restClient;
    }

    public String placeOrder(String productId) {

        ResponseEntity<Inventory> body = restClient
                .get()
                .uri("http://localhost:8081/product/productId", productId)
                .retrieve()
                .toEntity(Inventory.class);

        updateQuantity(body.getBody());

        return body != null && body.getBody().getQuantity() > 0 ? "IN STOCK " : "OUT OF STOCK";
    }

    private void updateQuantity(Inventory inventory) {

        inventory.setQuantity(inventory.getQuantity()-1);
        restClient.post()
                .uri("http://localhost:8081/product/productId")
                .body(inventory)
                .retrieve()
                .toBodilessEntity();

    }


}
