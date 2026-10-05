package com.quickcart.product.details.repository;

import com.quickcart.product.details.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetails extends JpaRepository<Product, Long> {
    Product findByProductId(Long productId);

}
