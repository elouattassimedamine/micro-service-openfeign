package com.example.billing.Service;

import com.example.billing.Entity.Bills;
import com.example.billing.Entity.ProductItem;

import java.util.List;

public interface ProductItemService {

    ProductItem save(ProductItem productItem);
    ProductItem findById(Long id);
    List<ProductItem> findAll();
}
