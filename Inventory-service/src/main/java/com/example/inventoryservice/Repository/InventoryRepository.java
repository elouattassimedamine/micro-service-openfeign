package com.example.inventoryservice.Repository;

import com.example.inventoryservice.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
