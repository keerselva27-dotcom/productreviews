package com.quickcart.product.review.error;

public class ReviewExists extends RuntimeException{
    public ReviewExists(String message){
        super("review already exists");
    }
}
