package com.demo.ai_incident_resolver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ai_incident_resolver.dto.OrderRequest;
import com.demo.ai_incident_resolver.entity.OrderEntity;
import com.demo.ai_incident_resolver.service.OrderService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable Long id){
        return orderService.getOrder(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderRequest request){
        OrderEntity order = new OrderEntity();
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());

        OrderEntity savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }
}
