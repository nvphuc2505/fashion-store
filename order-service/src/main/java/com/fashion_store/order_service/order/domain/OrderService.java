package com.fashion_store.order_service.order.domain;

import com.fashion_store.order_service.dto.product.ProductClient;
import com.fashion_store.order_service.dto.product.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(ProductClient productClient,
                        OrderRepository orderRepository) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /*
    public Mono<Order> submitOrder(String productCode, int quantity) {
        return Mono
                .just(buildRejectedOrder(productCode, quantity))
                .flatMap(orderRepository::save);
    }
    */

    public Mono<Order> submitOrder(String productCode, int quantity) {

        // Calls the Catalog Service to check the product’s availability
        return productClient.getProductByProductCode(productCode)
                // If the book is available, it accepts the order.
                .map(productRequest -> buildAcceptedOrder(productRequest, quantity))
                // If the book is not available, it rejects the order.
                .defaultIfEmpty(buildRejectedOrder(productCode, quantity))
                .flatMap(orderRepository::save);
    }

    private static Order buildAcceptedOrder(ProductRequest product, int quantity) {
        return Order.of(product.getCode(), product.getName(),
                product.getSize(), quantity, product.getPrice(),
                null, null, OrderStatus.ACCEPTED);
    }

    private static Order buildRejectedOrder(String productCode, int quantity) {
        return Order.of(productCode, null, null, quantity,
                null, null, null, OrderStatus.REJECTED);
    }
}
