package com.fashion_store.catalog_service.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository
        extends CrudRepository<Product, Long> {

    Optional<Product> findByProductCode(String productCode);
    boolean existsByProductCode(String productCode);

}
