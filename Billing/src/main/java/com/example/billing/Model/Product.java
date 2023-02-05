package com.example.billing.Model;

import lombok.Data;

@Data
public class Product {

    private Long id_Inventory;

    private String libelle_Inventory;

    private int quantity_Inventory;

    private int price_Inventory;
}
