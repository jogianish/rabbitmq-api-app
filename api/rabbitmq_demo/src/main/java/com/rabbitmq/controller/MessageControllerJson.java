package com.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.dto.User;

import com.rabbitmq.publisher.RabbitMQJsonProducer;
@RestController
@RequestMapping("/rabbitmq")
@CrossOrigin(origins="*")
public class MessageControllerJson {
	private RabbitMQJsonProducer jsonProducer;

	public MessageControllerJson(RabbitMQJsonProducer jsonProducer) {
		super();
		this.jsonProducer = jsonProducer;
	}
	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
		jsonProducer.sendJsonMassage(user);
		return ResponseEntity.ok("Json message sent to Rabbitmq.....");
	}
	

}
