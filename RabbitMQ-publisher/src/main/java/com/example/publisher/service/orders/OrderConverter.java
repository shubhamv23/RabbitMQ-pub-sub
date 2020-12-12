package com.example.publisher.service.orders;

import com.example.publisher.apis.orders.request.Order;
import com.example.publisher.service.orders.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

	public OrderEntity convertDTOtoEntity(Order order) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setProductName(order.getProducts().get(0).getName());
		orderEntity.setRecipient(order.getRecipient().getBasicProfile().getName());

		return orderEntity;
	}
}
