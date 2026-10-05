package com.quickcart.product.review.repository;


import com.quickcart.product.review.dto.RequestDTO;
import com.quickcart.product.review.entity.ProductReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewItems extends JpaRepository<ProductReview, Long> {
    //submit a review - do a save in service
    //list review for a product
    List<ProductReview> findByproductId(Long productId);
    //get a aggregate rating of a review
    @Query(nativeQuery = true, value = "SELECT avg(rating) from product_reviews where product_id = :pid")
    Double getAvgRating(@Param("pid") Long productId);
    @Query(nativeQuery = true, value = "SELECT count(rating) from product_reviews where product_id= :pid")
    Integer getReviewItemCount(@Param("pid") Long ProductId);
    //allow one review per product per user
    Boolean existsByProductIdAndUserId(Long productId, Long userId);


}
