package com.quickcart.product.details.service;

import com.quickcart.product.details.entity.Product;
import com.quickcart.product.details.repository.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductDetails pr;
    public ProductService(ProductDetails pr) {
        this.pr = pr;
    }
    public Product getPr(Long id) {
        return pr.findByProductId(id);
    }
}
