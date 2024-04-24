package com.dev.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class Producer {

	/**
	 * 1 - Name of topic, 2 - Message
	 */
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void sendMsgToTopic(@RequestParam("message") String message) {
		kafkaTemplate.send("debjeet_topic", message);
	}
}
