package com.example.publisher.service.orders.entity;

import lombok.Data;

@Data
//@Entity
public class OrderEntity {
	//	@Id
	private String id;
	private String productName;
	private String recipient;
}
