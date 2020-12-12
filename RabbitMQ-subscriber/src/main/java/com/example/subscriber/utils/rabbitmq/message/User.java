package com.example.subscriber.utils.rabbitmq.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
	private String name;
	private String phoneNumber;
	private String email;
}
