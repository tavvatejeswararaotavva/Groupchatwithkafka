 Group Chat Application using Spring Boot, Kafka & WebSocket

A real-time group chat application built using Spring Boot, Kafka, WebSocket (STOMP + SockJS), and Thymeleaf UI.
Messages are produced to Kafka, consumed by the backend, and broadcast to all connected clients instantly.

 Features
Real-Time Chat

Messages appear instantly without page refresh

WebSocket (STOMP + SockJS) used for live updates

Kafka consumer forwards messages to WebSocket topic

Kafka-backed Messaging

Messages are published to a Kafka topic

Kafka consumer reads messages & sends to clients

Multi-user Chat

Multiple users can join with different names

All users see the same messages live

Simple UI

Chat interface built using Thymeleaf

Shows history + new incoming messages

 Tech Stack
Backend

Java 17

Spring Boot

Spring Web

Spring WebSocket (STOMP + SockJS)

Spring Kafka

Messaging

Apache Kafka

Zookeeper

Frontend

HTML5 + Thymeleaf Templates

JavaScript (SockJS + STOMP client)

 Requirements
Tool	Version
Java	17+
Kafka	2.x / 3.x
Zookeeper	Required
Maven	3.x
Browser	Any modern browser
## ▶️ How to Run the Project (Windows)
 1️⃣ Start Zookeeper

Go to Kafka installation folder:

cd F:\kafka\kafka_2.13-3.9.1
bin\windows\zookeeper-server-start.bat config\zookeeper.properties


Keep the window OPEN.

2️⃣ Start Kafka Broker

Open another CMD:

cd F:\kafka\kafka_2.13-3.9.1
bin\windows\kafka-server-start.bat config\server.properties

3️⃣ Create Kafka Topic (One-time)
cd F:\kafka\kafka_2.13-3.9.1
bin\windows\kafka-topics.bat --create --topic group-chat --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1


Verify:

bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

4️⃣ Run the Spring Boot Application

From your project folder:

mvn spring-boot:run


Application starts on:

 http://localhost:9090

5️⃣ Open the Chat App

Open browser:

http://localhost:9090


Enter username → start chatting.

Open another browser window to simulate another user.

 🔄 Architecture Flow
User → Spring Boot → Kafka (Producer)
Kafka (Consumer) → WebSocket → All Connected Users


Real-time updates are delivered using STOMP WebSocket.

 Folder Structure (Short Overview)
src/main/java/com/kafka/groupchat
├── controller/ChatController.java
├── service/ChatProducer.java
├── service/ChatConsumer.java
├── config/WebSocketConfig.java
├── model/ChatMessage.java
└── templates/
  ├── login.html
  └── chat.html

## ✨ Future Enhancements (Optional)

Message persistence using MySQL / PostgreSQL

Online users list

Typing indicator

Multiple chat rooms

Message formatting & UI improvements

JWT-based authentication