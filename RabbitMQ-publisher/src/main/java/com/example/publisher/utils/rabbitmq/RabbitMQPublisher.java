package com.example.publisher.utils.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQPublisher {

	private final RabbitTemplate rabbitTemplate;
	private final RabbitMQProperties rabbitMQProperties;

	@Autowired
	public RabbitMQPublisher(RabbitTemplate rabbitTemplate, RabbitMQProperties rabbitMQProperties) {
		this.rabbitTemplate = rabbitTemplate;
		this.rabbitMQProperties = rabbitMQProperties;
	}

	public void publishMessageToDirectExchange(Object object) {
		log.info("publishing request to direct exchange.");
		rabbitTemplate.convertAndSend(rabbitMQProperties.getDirectExchangeName(), rabbitMQProperties.getDirectOrdersRoutingKey(), object);
	}

	public void publishMessageToTopicExchangeBangaloreLoc(Object object) {
		//This will publish message to bangaloreOrderQueue and allOrderQueue
		log.info("publishing request to topic exchange with routing key: {}", rabbitMQProperties.getBangaloreOrdersRoutingKey());
		rabbitTemplate.convertAndSend(rabbitMQProperties.getTopicExchangeName(), rabbitMQProperties.getBangaloreOrdersRoutingKey(), object);
	}

	public void publishMessageToTopicExchangeMumbaiLoc(Object object) {
		//This will publish message to mumbaiOrderQueue and allOrderQueue
		log.info("publishing request to topic exchange with routing key: {}", rabbitMQProperties.getMumbaiOrdersRoutingKey());
		rabbitTemplate.convertAndSend(rabbitMQProperties.getTopicExchangeName(), rabbitMQProperties.getMumbaiOrdersRoutingKey(), object);
	}

	public void publishMessageToTopicExchangeAllLocations(Object object) {
		//This will only publish message to allOrdersQueue
		log.info("publishing request to topic exchange with routing key: {}", rabbitMQProperties.getAllOrdersRoutingKey());
		rabbitTemplate.convertAndSend(rabbitMQProperties.getTopicExchangeName(), rabbitMQProperties.getAllOrdersRoutingKey(), object);
	}

	public void publishMessageToFanoutExchange(Object object) {
		//This will only publish message to all queues under fanout exchange.
		log.info("publishing request to fanout exchange");
		rabbitTemplate.convertAndSend(rabbitMQProperties.getFanoutExchange(), "", object);
	}
}
