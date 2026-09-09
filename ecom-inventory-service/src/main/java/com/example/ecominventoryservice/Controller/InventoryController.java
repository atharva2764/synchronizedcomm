package com.example.ecominventoryservice.Controller;

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
    public String checknInventory(@PathVariable String productId){
        return inventoryService.checkInventory(productId);
    }
}
