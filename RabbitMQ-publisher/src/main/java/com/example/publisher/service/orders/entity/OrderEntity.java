package com.example.publisher.service.orders.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class OrderEntity {
	@Id
	private String id;
	private String productName;
	private String recipient;
}
