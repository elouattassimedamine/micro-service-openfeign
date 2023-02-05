package com.example.billing.Entity;

import com.example.billing.Model.Customer;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Bills {
    @Id
    @GeneratedValue
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bills")
    private List<ProductItem> productItemList;

    @Transient
    private Customer customer;
}
