package com.example.customerservice.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long id_Customer;

    private String name_Customer;

    private  String email_Customer;
}
