package com.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.publisher.RabbitMQProducer;
@RestController
@RequestMapping("/rabbitmq")
public class MessageController {
	private RabbitMQProducer producer;

	public MessageController(RabbitMQProducer producer) {
		super();
		this.producer = producer;
	}
	@GetMapping("/sendmessage")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessage(message);
		return  ResponseEntity.ok("Message sent to RabbitMq.....");
	}

}
