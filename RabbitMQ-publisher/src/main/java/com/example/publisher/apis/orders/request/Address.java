package com.example.publisher.apis.orders.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
	private String addressType;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String country;
}
