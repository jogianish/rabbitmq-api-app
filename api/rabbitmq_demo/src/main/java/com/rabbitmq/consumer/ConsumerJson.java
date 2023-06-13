package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.dto.User;
@Service
public class ConsumerJson {
	private static final Logger LOGGER=LoggerFactory.getLogger(ConsumerJson.class);
	
	@RabbitListener(queues="${rabbitmq.json.queue.name}")
	public void consumerJson(User user) {
		LOGGER.info(String.format("Received Json Message -> %s", user.toString()));
	}

}
