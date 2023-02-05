package com.example.billing.Service;

import com.example.billing.Model.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name = "INVENTORY")
public interface ProductRestClient {

    @GetMapping("/find/{id}")
    Product findProductById(@PathVariable Long id);

    @GetMapping("/findAll")
    Collection<Product> allProduct();
}
