package com.example.ecomorderservice.Service;

import com.example.ecomorderservice.Clients.InventoryClient;
import com.example.ecomorderservice.dto.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final RestClient restClient;
    private final InventoryClient inventoryClient;

    public OrderService(RestTemplate restTemplate, RestClient restClient, InventoryClient inventoryClient) {
        this.restTemplate = restTemplate;
        this.restClient = restClient;
        this.inventoryClient = inventoryClient;
    }

    public String placeOrder(long product_id) {

        /*
                            //RESTCLIENT

        ResponseEntity<Inventory> body = restClient
                .get()
                .uri("http://localhost:8081/product/{product_id}", product_id)
                .retrieve()
                .toEntity(Inventory.class);

        System.out.println(body.getBody());

         */

        Inventory inventory = inventoryClient.getInventory(product_id);
        int quantity = inventory.getQuantity();
        updateQuantity(inventory);


        return quantity > 0 ? "ORDER PLACED " : "OUT OF STOCK";
    }

    private void updateQuantity(Inventory inventory) {

        inventory.setQuantity(inventory.getQuantity() - 1);


        System.out.println("////////////////////////////////////////////////////////////////////////////");
        System.out.println(inventory);

/*
        restClient.post()
                .uri("http://localhost:8081/product")
                .body(inventory)
                .retrieve()
                .toBodilessEntity();
 */
        inventoryClient.updateProduct(inventory);
    }


}
