package com.kafka.groupchat.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.kafka.groupchat.model.ChatMessage;
@Service
public class ChatConsumer {
	private final SimpMessagingTemplate messagingTemplate;

	public ChatConsumer(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}

	@KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(ChatMessage message) {
		messagingTemplate.convertAndSend("/topic/messages", message);
		System.out.println(message.getSender() + ": " + message.getText());
	}
}
