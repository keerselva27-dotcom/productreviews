package com.quickcart.product.review.service;

import com.quickcart.product.review.controller.ContolerExceptionHandler;
import com.quickcart.product.review.dto.RequestDTO;
import com.quickcart.product.review.dto.ResponseDTO;
import com.quickcart.product.review.entity.ProductReview;
import com.quickcart.product.review.error.ReviewExists;
import com.quickcart.product.review.repository.ProductReviewItems;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;


@Service
public class ProductReviewService {
    ProductReviewItems prd;
    ContolerExceptionHandler exception = new ContolerExceptionHandler();
    ProductReviewService(ProductReviewItems prd) {
        this.prd = prd;
    }
    //submit a review one review per user
    public ProductReview SubmitAReview(RequestDTO requestDTO) {
        ProductReview pr = new ProductReview();
        //check if user had submitted a request already
        Boolean existing = prd.existsByProductIdAndUserId(requestDTO.getProductId(), requestDTO.getUserId());
        if(existing){
            throw new ReviewExists("Review already exists");
        } else {
            pr.setProductId(requestDTO.getProductId());
            pr.setRating(requestDTO.getRating());
            pr.setComment(requestDTO.getComment());
            pr.setUserID(requestDTO.getUserId());
            prd.save(pr);
        }
        return pr;
    }
    //get all review
    public List<ProductReview> getProductReviews(Long productId ){
        return prd.findByproductId(productId);
    }
    //delete
    public void deleteById(Long reviewId){
        prd.deleteById(reviewId);
    }
    //aggreate
    public Double aggregateReviews(Long productId){
        Integer reviewcount = prd.getReviewItemCount(productId);
        Double avgrating = prd.getAvgRating(productId);
        if(reviewcount > 0 && avgrating != null){
            return  Math.round(avgrating*100)/100.0;
        }
        return 0.0;
    }
    //sumbit and update avgrating
    @Transactional
    public ResponseDTO SubmitAReviewAndGetAvg(RequestDTO requestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        SubmitAReview(requestDTO);
        if(true) throw new RuntimeException("simulated exception");
        responseDTO.setAvgRating(aggregateReviews(requestDTO.getProductId()));
        responseDTO.setProductId(requestDTO.getProductId());
        responseDTO.setRating(requestDTO.getRating());
        responseDTO.setComment(requestDTO.getComment());
        responseDTO.setUserId(requestDTO.getUserId());
        return responseDTO;
    }

}
