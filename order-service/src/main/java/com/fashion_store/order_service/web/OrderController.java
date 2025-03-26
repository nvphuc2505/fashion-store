package com.fashion_store.order_service.web;

import com.fashion_store.order_service.order.domain.Order;
import com.fashion_store.order_service.order.domain.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> fetchAllOrder() {
        System.out.println("Fetching all orders...");
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> postOrder(@Valid @RequestBody Order order) {
        return orderService.submitOrder(order.getProductCode(), order.getProductQuantity());
    }
}
