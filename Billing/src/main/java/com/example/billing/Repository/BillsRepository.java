package com.example.billing.Repository;

import com.example.billing.Entity.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepository extends JpaRepository<Bills,Long> {
}
