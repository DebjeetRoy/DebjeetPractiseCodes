package com.dev.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "debjeet_topic", groupId = "debjeet_group")
	public void listenToTopic(String receivMessage) {
		System.out.println("The received message : " + receivMessage);
	}
}
