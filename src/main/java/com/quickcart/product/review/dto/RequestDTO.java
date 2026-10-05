package com.quickcart.product.review.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class RequestDTO {
    String comment;
    Long productId;
    Long userId;
    Double rating;
}
