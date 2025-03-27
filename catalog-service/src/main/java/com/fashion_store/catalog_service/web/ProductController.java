package com.fashion_store.catalog_service.web;

import com.fashion_store.catalog_service.domain.Product;
import com.fashion_store.catalog_service.domain.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products", produces = "application/json")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> get() {
        return productService.viewProductList();
    }

    @GetMapping("/{productCode}")
    public Product getByProductCode(@PathVariable String productCode) {
        return productService.viewProductDetails(productCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product post(@Valid @RequestBody Product product) {
        return productService.addProductToCatalog(product);
    }
}
