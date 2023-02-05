package com.example.billing.Service;

import com.example.billing.Entity.Bills;
import com.example.billing.Repository.BillsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BillsServiceImpl implements BillsService {
    private BillsRepository billsRepository;

    public BillsServiceImpl(BillsRepository billsRepository) {
        this.billsRepository = billsRepository;
    }

    @Override
    public Bills save(Bills bills) {
        return billsRepository.save(bills);
    }

    @Override
    public Bills findById(Long id) {
        return billsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bills> findAll() {
        return billsRepository.findAll();
    }
}
