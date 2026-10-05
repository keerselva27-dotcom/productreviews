package com.quickcart.product.review.controller;
import com.quickcart.product.review.dto.RequestDTO;
import com.quickcart.product.review.dto.ResponseDTO;
import com.quickcart.product.review.entity.ProductReview;
import com.quickcart.product.review.service.ProductReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductReviewController {
    ProductReviewService prd;
    ProductReviewController(ProductReviewService pr){
        this.prd = pr;
    }
    @PostMapping("/submit")
    public ResponseEntity<ProductReview> submitReviews(@RequestBody RequestDTO requestDTO){
        ProductReview rp = prd.SubmitAReview(requestDTO);
        return ResponseEntity.ok().body(rp);
    }
    //you can call this by GET /reviews/156?page=1
    @GetMapping("/reviews/{productId}")
    public List<ProductReview> listAll(@PathVariable Long productId, @PageableDefault(size = 5) Pageable pageable){
        return prd.getProductReviews(productId);

    }
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<ProductReview> deleteReviews(@PathVariable Long id){
        prd.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/reviews/aggregate/{id}")
    public ResponseEntity<Double> aggregateReviews(@PathVariable Long id) {
        Double review = prd.aggregateReviews(id);
        return ResponseEntity.ok().body(review);
    }
    @PostMapping("submit/avgRating")
    public ResponseEntity<ResponseDTO> submitReviewandGetRating(@RequestBody RequestDTO requestDTO){
        return ResponseEntity.ok().body(prd.SubmitAReviewAndGetAvg(requestDTO));
    }
}
