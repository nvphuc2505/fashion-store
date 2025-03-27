package com.fashion_store.catalog_service.domain;

import com.fashion_store.catalog_service.domain.exception.ProductAlreadyExistsException;
import com.fashion_store.catalog_service.domain.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> viewProductList() {
        return productRepository.findAll();
    }

    public Product viewProductDetails(String productCode) {
        return productRepository
                .findByProductCode(productCode)
                .orElseThrow(() -> new ProductNotFoundException(productCode));
    }

    public Product addProductToCatalog(Product product) {

        if (productRepository.existsByProductCode(product.getCode()))
            throw new ProductAlreadyExistsException(product.getCode());

        return productRepository.save(product);
    }


}
