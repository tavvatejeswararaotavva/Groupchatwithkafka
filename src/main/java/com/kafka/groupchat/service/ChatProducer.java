package com.kafka.groupchat.service;

import org.apache.kafka.common.network.Send;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.groupchat.model.ChatMessage;
@Service
public class ChatProducer {
    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    @Value("${app.kafka.topic}")
    private String topic;

    public ChatProducer(KafkaTemplate<String, ChatMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ChatMessage message) {
        kafkaTemplate.send(topic, message);
    }
}
