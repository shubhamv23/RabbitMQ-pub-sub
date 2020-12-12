package com.example.publisher.apis.orders.controller;

import com.example.publisher.apis.orders.request.Order;
import com.example.publisher.utils.rabbitmq.RabbitMQPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Slf4j
public class EventPublishController {

	private final RabbitMQPublisher rabbitMQPublisher;

	public EventPublishController(RabbitMQPublisher rabbitMQPublisher) {
		this.rabbitMQPublisher = rabbitMQPublisher;
	}

	@PostMapping
	public void placeOrder(@RequestBody Order order) throws JsonProcessingException {
		log.info("Request: {} recieved to process order", order.toString());
		rabbitMQPublisher.publishMessageToDirectExchange(order);
	}

	@PostMapping(path = "/location/{location}")
	public void placeOrderForLocation(@RequestBody Order order, @PathVariable String location) throws JsonProcessingException {
		log.info("Request: {} recieved to process order for {} location", order.toString(), location);
		if ("bangalore".equalsIgnoreCase(location)) {
			rabbitMQPublisher.publishMessageToTopicExchangeBangaloreLoc(order);
		} else if ("mumbai".equalsIgnoreCase(location)) {
			rabbitMQPublisher.publishMessageToTopicExchangeMumbaiLoc(order);
		} else {
			rabbitMQPublisher.publishMessageToTopicExchangeAllLocations(order);
		}
	}

	@PostMapping(path = "/info")
	public void publishLocationInformation(@RequestBody Order order) throws JsonProcessingException {
		log.info("Request: {} recieved to publish order to all queues in fanout exchange as info", order.toString());
		rabbitMQPublisher.publishMessageToFanoutExchange(order);
	}
}
