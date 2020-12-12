package com.example.subscriber.utils.rabbitmq.message;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Order implements Serializable {
	private String orderId;
	private List<Product> products;
	private Recipient recipient;
}
