package com.quickcart.product.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@MappedSuperclass
@Data
public abstract class AbstractEntityDates {
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime CreatedAt= LocalDateTime.now();
    @LastModifiedDate
    @Column(name = "update_date", nullable = false, updatable = true)
    LocalDateTime UpdatedAt = LocalDateTime.now();
}
