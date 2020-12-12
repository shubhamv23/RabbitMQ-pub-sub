package com.example.publisher.utils.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

	private final RabbitMQProperties rabbitMQProperties;

	@Autowired
	public RabbitMQConfiguration(RabbitMQProperties rabbitMQProperties) {
		this.rabbitMQProperties = rabbitMQProperties;
	}

	@Bean
	Queue mumbaiQueue() {
		return new Queue(rabbitMQProperties.getMumbaiOrdersQueue(), true);
	}

	@Bean
	Queue bangaloreOrderQueue() {
		return new Queue(rabbitMQProperties.getBangaloreOrdersQueue(), true);
	}

	@Bean
	Queue allOrdersQueue() {
		return new Queue(rabbitMQProperties.getAllOrdersQueue(), true);
	}

	@Bean
	Queue directQueue() {
		return new Queue(rabbitMQProperties.getDirectQueue(), true);
	}

	@Bean
	Queue fanoutQueue1() {
		return new Queue(rabbitMQProperties.getFanoutQueue1(), true);
	}

	@Bean
	Queue fanoutQueue2() {
		return new Queue(rabbitMQProperties.getFanoutQueue2(), true);
	}

	@Bean
	Queue fanoutQueue3() {
		return new Queue(rabbitMQProperties.getFanoutQueue3(), true);
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(rabbitMQProperties.getTopicExchangeName());
	}

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(rabbitMQProperties.getDirectExchangeName());
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(rabbitMQProperties.getFanoutExchange());
	}

	@Bean
	Binding directQueueBinding(@Qualifier("directQueue") Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(rabbitMQProperties.getDirectOrdersRoutingKey());
	}

	@Bean
	Binding mumbaiOrdersTopicQueueBinding(@Qualifier("mumbaiQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(rabbitMQProperties.getMumbaiOrdersRoutingKey());
	}

	@Bean
	Binding bangaloreOrdersTopicQueueBinding(@Qualifier("bangaloreOrderQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(rabbitMQProperties.getBangaloreOrdersRoutingKey());
	}

	@Bean
	Binding allOrderTopicQueueBinding(@Qualifier("allOrdersQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(rabbitMQProperties.getAllOrdersRoutingKey());
	}

	@Bean
	Binding fanoutQueueBinding1(@Qualifier("fanoutQueue1") Queue queue, FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}

	@Bean
	Binding fanoutQueueBinding2(@Qualifier("fanoutQueue2") Queue queue, FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}

	@Bean
	Binding fanoutQueueBinding3(@Qualifier("fanoutQueue3") Queue queue, FanoutExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
