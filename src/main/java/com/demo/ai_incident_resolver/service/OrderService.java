package com.demo.ai_incident_resolver.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.ai_incident_resolver.entity.OrderEntity;
import com.demo.ai_incident_resolver.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderEntity order){
        return orderRepository.save(order);
    }

    public Optional<OrderEntity> getOrder(Long id){
        return orderRepository.findById(id);
    }
}
