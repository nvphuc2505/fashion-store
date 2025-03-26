package com.fashion_store.order_service.order.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> submitOrder(String productCode, int quantity) {
        return Mono.just(buildRejectedOrder(productCode, quantity)).flatMap(orderRepository::save);
    }

    public static Order buildRejectedOrder(String productCode, int quantity) {
        return Order.of(productCode, null, null, quantity,
                null, null, null, OrderStatus.REJECTED);
    }
}
