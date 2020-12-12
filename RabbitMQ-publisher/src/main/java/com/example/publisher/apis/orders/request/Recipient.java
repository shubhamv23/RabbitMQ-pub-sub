package com.example.publisher.apis.orders.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Recipient implements Serializable {
	private User basicProfile;
	private List<Address> addresses;
}
