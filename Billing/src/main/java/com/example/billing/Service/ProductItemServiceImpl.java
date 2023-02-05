package com.example.billing.Service;

import com.example.billing.Entity.ProductItem;
import com.example.billing.Repository.ProductItemsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductItemServiceImpl implements ProductItemService {
    private ProductItemsRepository productItemsRepository;

    public ProductItemServiceImpl(ProductItemsRepository productItemsRepository) {
        this.productItemsRepository = productItemsRepository;
    }

    @Override
    public ProductItem save(ProductItem productItem) {
        return productItemsRepository.save(productItem);
    }

    @Override
    public ProductItem findById(Long id) {
        return productItemsRepository.findById(id).get();
    }

    @Override
    public List<ProductItem> findAll() {
        return productItemsRepository.findAll();
    }
}
