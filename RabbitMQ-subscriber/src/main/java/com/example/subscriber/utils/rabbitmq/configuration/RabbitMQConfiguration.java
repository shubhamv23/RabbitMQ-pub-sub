package com.example.subscriber.utils.rabbitmq.configuration;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
	@Bean
	public Declarables topicExchangeBindings() {
		TopicExchange topicExchange = new TopicExchange(Constant.topicExchangeName);
		Queue mumbaiOrdersQueue = new Queue(Constant.mumbaiOrdersQueue, false);
		Queue bangaloreOrdersQueue = new Queue(Constant.bangaloreOrdersQueue, false);
		Queue allOrdersQueue = new Queue(Constant.allOrdersQueue, false);
		return new Declarables(
				mumbaiOrdersQueue,
				bangaloreOrdersQueue,
				allOrdersQueue,
				topicExchange,
				BindingBuilder
						.bind(mumbaiOrdersQueue)
						.to(topicExchange)
						.with(Constant.mumbaiOrdersRoutingKey),
				BindingBuilder
						.bind(bangaloreOrdersQueue)
						.to(topicExchange)
						.with(Constant.bangaloreOrdersRoutingKey),
				BindingBuilder
						.bind(allOrdersQueue)
						.to(topicExchange)
						.with(Constant.allOrdersRoutingKey)
		);
	}

	@Bean
	public Declarables directExchangeBindings() {
		TopicExchange topicExchange = new TopicExchange(Constant.directExchangeName);
		Queue topicExchangeQueue = new Queue(Constant.directQueue, false);
		return new Declarables(
				topicExchangeQueue,
				topicExchange,
				BindingBuilder
						.bind(topicExchangeQueue)
						.to(topicExchange)
						.with(Constant.directOrdersRoutingKey)
		);
	}

	@Bean
	public Declarables fanoutExchangeBindings() {
		FanoutExchange fanoutExchange = new FanoutExchange(Constant.fanoutExchange);
		Queue fanoutExchangeQueue1 = new Queue(Constant.fanoutQueue1, false);
		Queue fanoutExchangeQueue2 = new Queue(Constant.fanoutQueue2, false);
		Queue fanoutExchangeQueue3 = new Queue(Constant.fanoutQueue3, false);
		return new Declarables(
				fanoutExchangeQueue1,
				fanoutExchangeQueue2,
				fanoutExchangeQueue3,
				fanoutExchange,
				BindingBuilder.bind(fanoutExchangeQueue1).to(fanoutExchange),
				BindingBuilder.bind(fanoutExchangeQueue2).to(fanoutExchange),
				BindingBuilder.bind(fanoutExchangeQueue3).to(fanoutExchange));
	}

	private class Constant {
		public final static String directExchangeName = "directExchange";
		public final static String directQueue = "ordersQueue";
		public final static String directOrdersRoutingKey = "orders";

		public final static String topicExchangeName = "topicExchange";
		public final static String mumbaiOrdersQueue = "mumbaiOrdersQueue";
		public final static String mumbaiOrdersRoutingKey = "orders.mumbai";

		public final static String bangaloreOrdersQueue = "bangaloreOrdersQueue";
		public final static String bangaloreOrdersRoutingKey = "orders.bangalore";

		public final static String allOrdersQueue = "allOrdersQueue";
		public final static String allOrdersRoutingKey = "orders.#";

		public final static String fanoutExchange = "fanoutExchange";
		public final static String fanoutQueue1 = "fanoutQueue1";
		public final static String fanoutQueue2 = "fanoutQueue2";
		public final static String fanoutQueue3 = "fanoutQueue3";
	}
}
