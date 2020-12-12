package com.example.publisher.apis.orders.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
	private String name;
	private String price;
}
