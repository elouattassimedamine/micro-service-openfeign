package com.example.inventoryservice.Service;

import com.example.inventoryservice.Entity.Inventory;
import com.example.inventoryservice.Repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory findById(Long id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }
}
