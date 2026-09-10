package com.example.ecomorderservice.Clients;

import com.example.ecomorderservice.Clients.Config.InventoryFeignClientConfig;
import com.example.ecomorderservice.dto.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ecom-inventory-service",
        configuration = InventoryFeignClientConfig.class
)
public interface InventoryClient {

    @GetMapping("/product/{product_id}")
    Inventory getInventory(@PathVariable long product_id);


    @PostMapping("/product")
    void updateProduct(@RequestBody Inventory inventory);
}
