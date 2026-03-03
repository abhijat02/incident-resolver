package com.demo.ai_incident_resolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ai_incident_resolver.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
