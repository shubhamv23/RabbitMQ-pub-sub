package com.example.publisher.service.orders.repository;

import com.example.publisher.service.orders.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, String> {
}
