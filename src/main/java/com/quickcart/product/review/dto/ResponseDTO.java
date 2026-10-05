package com.quickcart.product.review.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    String comment;
    Long productId;
    Long userId;
    Double rating;
    Double avgRating;

}
