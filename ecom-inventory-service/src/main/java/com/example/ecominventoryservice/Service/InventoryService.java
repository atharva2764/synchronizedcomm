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

    public Inventory checkInventory(long product_id) {
        Optional<Inventory> byId = inventoryRepo.findById((int) product_id);
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

    public String deleteProduct(long productId) {
        inventoryRepo.deleteById((int) productId);

        return "deleted";

    }
}
