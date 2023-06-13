package com.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.dto.User;
@Service
public class RabbitMQJsonProducer {
	private static final Logger LOGGER =LoggerFactory.getLogger(RabbitMQJsonProducer.class);
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	@Value("${rabbitmq.routing.key.json}")
	private String routingKeyJason;
	
	private RabbitTemplate rabbitTemplate;

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
public void sendJsonMassage(User user) {
	LOGGER.info(String.format("Json message sent ->%s", user.toString()));
	rabbitTemplate.convertAndSend(exchange, routingKeyJason, user);
}
}
