package com.example.ecominventoryservice.Service;

import com.example.ecominventoryservice.Entity.Inventory;
import com.example.ecominventoryservice.Repository.InventoryRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {


    private final InventoryRepo inventoryRepo;

    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public Inventory checkInventory(String productId) {
        Optional<Inventory> byId = inventoryRepo.findById(Integer.valueOf((productId)));
//        if (byId != null && byId.get().getQuantity() > 0) return "IN STOCK" ;
//        else
//        return "NOT IN STOCK";
        return byId.get();
    }

    public String addProduct(Inventory inventory) {
        Inventory save = inventoryRepo.save(inventory);
        return "addedd";
    }


    public String updateProduct(Inventory inventory) {
        Inventory update = inventoryRepo.save(inventory);
        return "Product Updated";
    }

    public String deleteProduct(String productId) {
        inventoryRepo.deleteById(Integer.valueOf(productId));

        return "deleted";

    }
}
