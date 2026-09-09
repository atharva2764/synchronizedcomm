package com.example.ecominventoryservice.Service;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public String checkInventory(String productId){
        return productId.equals("1")?"IN STOCK":"OUT OF STOCK";
    }

}
