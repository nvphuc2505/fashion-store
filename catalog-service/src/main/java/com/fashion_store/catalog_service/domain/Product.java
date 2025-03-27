package com.fashion_store.catalog_service.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Table(name = "products")
public class Product {

    @Id
    private Long id;

    private String code;

    @NotBlank(message = "The product name must be defined.")
    private String name;

    private String size;

    private String color;

    private BigDecimal price;

    private String description;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Version
    private int version;



    private Product(Long id, String code, String name, String size,
                    String color, BigDecimal price, String description,
                    Instant createdDate, Instant lastModifiedDate, int version) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.description = description;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.version = version;
    }

    public static Product of(String productCode, String productName, String productSize,
                             String productColor, BigDecimal productPrice, String description) {

        return new Product(null, productCode, productName, productSize, productColor,
                productPrice, description, null, null, 0);
    }
}
