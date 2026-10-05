package com.quickcart.product.review.entity;

import jakarta.persistence.*;

@Table(name = "product_reviews")
@Entity
public class ProductReview extends AbstractEntityDates{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private Long reviewid;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "user_id")
    private Long userId;
    private Double rating;
    private String comment;

    public Long getProductId() {
        return productId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public Long getUserId() {
        return userId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setUserID(Long userId) {
        this.userId = userId;
    }
    public Long getReviewid() {
        return reviewid;
    }
}
