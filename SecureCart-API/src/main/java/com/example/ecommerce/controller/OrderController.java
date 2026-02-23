package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@Valid @RequestBody OrderRequest request, Authentication authentication) {
        return orderService.placeOrder(authentication.getName(), request);
    }

    @GetMapping("/me")
    public List<Order> myOrders(Authentication authentication) {
        return orderService.getOrdersForUser(authentication.getName());
    }
}
