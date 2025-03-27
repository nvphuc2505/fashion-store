package com.fashion_store.catalog_service.domain.exception;

public class ProductAlreadyExistsException
        extends RuntimeException {

    public ProductAlreadyExistsException(String productCode) {
        super("A product with code " + productCode + " already exists.");
    }

}
