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

    @GetMapping("/{productId}")
    public Inventory checknInventory(@PathVariable String productId) {
        return inventoryService.checkInventory(productId);
    }


    @PostMapping()
    public String addProduct(@RequestBody Inventory inventory) {
        return inventoryService.addProduct(inventory);
    }

    @PutMapping
    public String updateProduct(@RequestBody Inventory inventory) {
        return inventoryService.updateProduct(inventory);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        return inventoryService.deleteProduct(productId);
    }

}
