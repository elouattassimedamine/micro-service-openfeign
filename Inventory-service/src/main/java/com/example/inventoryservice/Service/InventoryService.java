package com.example.inventoryservice.Service;

import com.example.inventoryservice.Entity.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory save(Inventory inventory);
    Inventory findById(Long id);
    List<Inventory> findAll();
}
