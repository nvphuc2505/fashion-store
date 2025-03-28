package com.fashion_store.order_service.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    // XXX-XXX-XXX
    private String code;

    private String name;

    private String size;

    private BigDecimal price;

}
