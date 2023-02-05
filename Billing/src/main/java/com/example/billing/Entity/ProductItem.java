package com.example.billing.Entity;

import com.example.billing.Model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ProductItem {

    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bills bills;
    private int quantite;
    private double price;
    private double discount;

    @Transient
    private Product product;
}
