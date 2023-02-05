package com.example.billing.Repository;

import com.example.billing.Entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemsRepository extends JpaRepository<ProductItem,Long> {
}
