package com.fashion_store.order_service.product.dto;

import com.fashion_store.order_service.product.dto.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*  This class is going to use the WebClient bean to send HTTP
 *  calls to the GET /books/{bookIsbn} endpoint exposed by Catalog Service
 *  through its fluent API
 */
@Component
public class ProductClient {

    private static final String PRODUCTS_ROOT_API = "/products/";
    private final WebClient webClient;

    @Autowired
    public ProductClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ProductRequest> getProductByProductCode(String productCode) {
        return webClient
                .get()
                .uri(PRODUCTS_ROOT_API + productCode)
                .retrieve()
                .bodyToMono(ProductRequest.class);
    }

}
