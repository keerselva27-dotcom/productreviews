package com.quickcart.product.details.controller;

import com.quickcart.product.details.dto.ProductAndReviewDto;
import com.quickcart.product.details.entity.Product;
import com.quickcart.product.review.dto.RequestDTO;
import com.quickcart.product.review.entity.ProductReview;
import com.quickcart.product.review.service.ProductReviewService;
import com.quickcart.product.details.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductandReview  {
    private final ProductService productService;
    private final ProductReviewService productReviewService;

    public ProductandReview(ProductService productService, ProductReviewService productReviewService) {
        this.productService = productService;
        this.productReviewService = productReviewService;

    }
    @GetMapping("/{id}")
    public ResponseEntity <ProductAndReviewDto> getProduct(@PathVariable Long id, @PageableDefault(size = 5) Pageable pageable){
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int start = (int) pageable.getOffset();
        ProductAndReviewDto productAndReviewDto = new ProductAndReviewDto();
        Product pr = productService.getPr(id);
        List<ProductReview> prr = productReviewService.getProductReviews(id);
        int end = Math.min(start + pageSize, prr.size());
        List<ProductReview> pageContent = (start <= end )? prr.subList(start,end) : List.of();
        Page<ProductReview> reviewPage = new PageImpl(pageContent,pageable,prr.size());
        Page<RequestDTO> result = reviewPage.map(r -> new RequestDTO(r.getComment(), r.getProductId(), r.getUserId(), r.getRating()));
        productAndReviewDto.setProduct(pr);
        PagedModel<RequestDTO> productReviews = new PagedModel<>(result);
        productAndReviewDto.setProductReviews(productReviews);
        return new ResponseEntity<>(productAndReviewDto, HttpStatus.OK);
    }

}
