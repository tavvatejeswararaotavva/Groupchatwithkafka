package com.kafka.groupchat.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.groupchat.model.ChatMessage;
@Service
public class ChatConsumer {
	
	@KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(ChatMessage message) {
        System.out.println(message.getSender() + ": " + message.getText());
	}
}
