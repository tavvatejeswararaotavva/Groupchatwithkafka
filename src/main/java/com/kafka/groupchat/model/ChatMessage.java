package com.kafka.groupchat.model;

import java.time.Instant;

public class ChatMessage {
    private String sender;
    private String text;
    private Instant timestamp;

    public ChatMessage() {}

    public ChatMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.timestamp = Instant.now();
    }

    // Getters and setters
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}