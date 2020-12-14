package com.example.subscriber.utils.rabbitmq.subscriber;

import com.example.subscriber.utils.rabbitmq.message.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQSubscriber {

	//direct exchange queue
	@RabbitListener(queues = "ordersQueue")
	public void receiveMessageForOrdersQueue(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Received message: {} from ordersQueue queue from DIRECT exchange.", order);
	}

	//topic exchange queue
	//listens to order.#
	@RabbitListener(queues = "allOrdersQueue")
	public void receiveMessageForAllOrdersQueue(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Headers: {}", message.getMessageProperties().getHeaders());
		log.info("Received message: {} from allOrdersQueue queue from TOPIC exchange.", order);
	}

	//topic exchange queue
	//listens to order.bangalore
	@RabbitListener(queues = "bangaloreOrdersQueue")
	public void receiveMessageForBangaloreOrdersQueue(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Received message: {} from bangaloreOrdersQueue queue from TOPIC exchange.", order);
	}

	//topic exchange queue
	//listens to order.mumbai
	@RabbitListener(queues = "mumbaiOrdersQueue")
	public void receiveMessageForMumbaiOrdersQueue(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Received message: {} from mumbaiOrdersQueue queue from TOPIC exchange.", order);
	}

	//fanout exchange queue1
	@RabbitListener(queues = "fanoutQueue1")
	public void receiveMessageForFanoutExchangeQueue1(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Received message: {} from fanoutExchangeQueue1 queue from FANOUT exchange.", order);
	}

	//fanout exchange queue2
	@RabbitListener(queues = "fanoutQueue2")
	public void receiveMessageForFanoutExchangeQueue2(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Received message: {} from fanoutExchangeQueue2 queue from FANOUT exchange.", order);
	}

	//fanout exchange queue3
	@RabbitListener(queues = "fanoutQueue3")
	public void receiveMessageForFanoutExchangeQueue3(@Payload final Order order, Message message) {
		log.info("Exchange name: {}", message.getMessageProperties().getReceivedExchange());
		log.info("Queue name: {}", message.getMessageProperties().getConsumerQueue());
		log.info("Routing key: {}", message.getMessageProperties().getReceivedRoutingKey());
		log.info("Received message: {} from fanoutExchangeQueue3 queue from FANOUT exchnage.", order);
	}
}
