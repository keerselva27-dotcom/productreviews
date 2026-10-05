package com.quickcart.product.details.controller;

import com.quickcart.product.details.entity.Product;
import com.quickcart.product.details.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getPr(id);
    }
}
