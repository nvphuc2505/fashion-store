package com.fashion_store.order_service.order.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    private String productCode;
    private String productName;
    private String productSize;
    private Integer productQuantity;
    private BigDecimal productPrice;
    private String productDescription;
    private String productColor;

    OrderStatus status;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Version
    private int version;



    private Order(Long id, String productCode, String name, String size,
                  Integer quantity, BigDecimal price, String description,
                  String color, OrderStatus status,
                  Instant createdDate, Instant lastModifiedDate, int version) {
        this.id = id;
        this.productCode = productCode;
        this.productName = name;
        this.productSize = size;
        this.productQuantity = quantity;
        this.productPrice = price;
        this.productDescription = description;
        this.productColor = color;
        this.status = status;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.version = version;
    }

    public static Order of(String productCode, String productName, String productSize,
                           Integer quantity, BigDecimal productPrice, String description,
                           String color, OrderStatus status) {

        return new Order(null, productCode, productName, productSize,
                quantity, productPrice, description, color, status, null, null, 0);
    }
}
