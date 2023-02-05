package com.example.billing.Service;

import com.example.billing.Entity.Bills;

import java.util.List;

public interface BillsService {

    Bills save(Bills bills);
    Bills findById(Long id);
    List<Bills> findAll();
}
