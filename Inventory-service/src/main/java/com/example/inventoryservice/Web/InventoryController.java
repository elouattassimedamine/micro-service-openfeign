package com.example.inventoryservice.Web;

import com.example.inventoryservice.Entity.Inventory;
import com.example.inventoryservice.Service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/save")
    @ResponseBody
    public Inventory save(@RequestBody Inventory inventory){
        return inventoryService.save(inventory);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Inventory findById(@PathVariable Long id){
        return inventoryService.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Inventory> findAll(){
        return inventoryService.findAll();
    }

}
