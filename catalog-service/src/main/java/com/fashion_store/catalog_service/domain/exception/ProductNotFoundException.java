package com.fashion_store.catalog_service.domain.exception;

public class ProductNotFoundException
        extends RuntimeException {

    public ProductNotFoundException(String productCode) {
        super("The product with code " + productCode + " was not found.");
    }

}
