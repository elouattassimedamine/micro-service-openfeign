package com.example.customerservice.Service;

import com.example.customerservice.Entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
}
