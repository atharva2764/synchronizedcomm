package com.example.ecominventoryservice.Repository;

import com.example.ecominventoryservice.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
