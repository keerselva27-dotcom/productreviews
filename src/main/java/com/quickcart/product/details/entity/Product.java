package com.quickcart.product.details.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDescription;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_stock")
    private int productStock;

}
