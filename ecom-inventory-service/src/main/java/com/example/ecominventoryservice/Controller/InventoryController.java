package com.example.ecominventoryservice.Controller;

import com.example.ecominventoryservice.Entity.Inventory;
import com.example.ecominventoryservice.Service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class InventoryController {


    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{product_id}")
    public Inventory checknInventory(@PathVariable long product_id) throws InterruptedException {
//        Thread.sleep(5000);
        return inventoryService.checkInventory(product_id);
    }


    @PostMapping
    public String addProduct(@RequestBody Inventory inventory) {
        return inventoryService.addProduct(inventory);
    }

    @PutMapping
    public String updateProduct(@RequestBody Inventory inventory) {
        return inventoryService.updateProduct(inventory);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable long productId) {
        return inventoryService.deleteProduct(productId);
    }

}
