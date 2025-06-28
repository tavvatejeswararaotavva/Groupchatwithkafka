package com.kafka.groupchat.controller;

import java.time.Instant;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kafka.groupchat.model.ChatMessage;
import com.kafka.groupchat.service.ChatProducer;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {

    private final List<ChatMessage> messages = new ArrayList<>();
    private final ChatProducer chatProducer;

    @Value("${app.kafka.topic}")
    private String topic;

    public ChatController(ChatProducer chatProducer) {
        this.chatProducer = chatProducer;
    }


    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/set-username")
    public String setUsername(@RequestParam String username, HttpSession session) {
        session.setAttribute("username", username);
        return "redirect:/chat";
    }

    @GetMapping("/chat")
    public String chatPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");

        if (username == null || username.isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("messages", messages);
        return "chat";
    }


    @PostMapping("/send")
    public String sendMessage(
            @RequestParam String sender,
            @RequestParam String text,
            HttpSession session
    ) {
        ChatMessage message = new ChatMessage();
        message.setSender(sender);
        message.setText(text);
        message.setTimestamp(Instant.now());

        chatProducer.sendMessage(message);
        messages.add(message);

        return "redirect:/chat";
    }

   
//    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
//    public void consume(ChatMessage message) {
//        messages.add(message);
//    }
}