package com.example.publisher.utils.rabbitmq;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProperties {
	//can maintain these in properties
	private String topicExchangeName = "topicExchange";
	private String directExchangeName = "directExchange";
	private String fanoutExchange = "fanoutExchange";
	private String directOrdersRoutingKey = "orders";
	private String mumbaiOrdersRoutingKey = "orders.mumbai";
	private String bangaloreOrdersRoutingKey = "orders.bangalore";
	private String allOrdersRoutingKey = "orders.#";
	private String mumbaiOrdersQueue = "mumbaiOrdersQueue";
	private String bangaloreOrdersQueue = "bangaloreOrdersQueue";
	private String allOrdersQueue = "allOrdersQueue";
	private String directQueue = "ordersQueue";
	private String fanoutQueue1 = "fanoutQueue1";
	private String fanoutQueue2 = "fanoutQueue2";
	private String fanoutQueue3 = "fanoutQueue3";

	public String getTopicExchangeName() {
		return topicExchangeName;
	}

	public String getDirectExchangeName() {
		return directExchangeName;
	}

	public String getFanoutExchange() {
		return fanoutExchange;
	}

	public String getDirectOrdersRoutingKey() {
		return directOrdersRoutingKey;
	}

	public String getMumbaiOrdersRoutingKey() {
		return mumbaiOrdersRoutingKey;
	}

	public String getBangaloreOrdersRoutingKey() {
		return bangaloreOrdersRoutingKey;
	}

	public String getMumbaiOrdersQueue() {
		return mumbaiOrdersQueue;
	}

	public String getBangaloreOrdersQueue() {
		return bangaloreOrdersQueue;
	}

	public String getAllOrdersQueue() {
		return allOrdersQueue;
	}

	public String getDirectQueue() {
		return directQueue;
	}

	public String getAllOrdersRoutingKey() {
		return allOrdersRoutingKey;
	}

	public String getFanoutQueue1() {
		return fanoutQueue1;
	}

	public String getFanoutQueue2() {
		return fanoutQueue2;
	}

	public String getFanoutQueue3() {
		return fanoutQueue3;
	}

}
