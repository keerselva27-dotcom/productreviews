package com.quickcart.product.details.dto;

import com.quickcart.product.details.entity.Product;
import com.quickcart.product.review.dto.RequestDTO;

import lombok.Data;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Data
@Setter
public class ProductAndReviewDto {
   Product product;
   PagedModel<RequestDTO> productReviews;

}
