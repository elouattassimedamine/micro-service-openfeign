package com.example.inventoryservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue
    private Long id_Inventory;

    private String libelle_Inventory;

    private int quantity_Inventory;

    private int price_Inventory;

}
