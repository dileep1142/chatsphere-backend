# ChatSphere Backend

A Spring Boot based backend for a real-time chat application featuring JWT authentication, room management, WebSocket communication, and MySQL database integration.

## Features

* User Registration
* User Login
* JWT Authentication
* Secure REST APIs
* Create Chat Rooms
* Retrieve Messages
* Real-Time Chat
* Typing Indicators
* MySQL Database Integration
* WebSocket Communication

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL
* JWT
* WebSocket
* STOMP
* SockJS
* Maven

## Architecture

Frontend (React.js)
|
REST APIs + JWT
|
Spring Boot Backend
|
MySQL Database

Real-Time Communication:
React → WebSocket → Spring Boot → WebSocket → React

## API Endpoints

Authentication

POST /api/auth/register
POST /api/auth/login

Rooms

GET /api/rooms
POST /api/rooms

Messages

GET /api/messages/room/{roomId}
POST /api/messages

WebSocket

/ws
/app/chat.send
/app/chat.typing
/topic/room/{roomId}
/topic/typing/{roomId}

## Configuration

application.properties

spring.application.name=chat-sphere

server.port=${PORT:8080}

spring.datasource.url=${DATABASE_URL:jdbc:mysql://localhost:3306/chatsphere}
spring.datasource.username=${DATABASE_USERNAME:root}
spring.datasource.password=${DATABASE_PASSWORD:your_password}

jwt.secret=${JWT_SECRET:your_secret_key}

## Run Locally

1. Clone repository

git clone https://github.com/dileep1142/chatsphere-backend.git

2. Configure MySQL

Create database:

CREATE DATABASE chatsphere;

3. Run application

./mvnw spring-boot:run

## Database Tables

* users
* rooms
* messages

## Future Enhancements

* Online/Offline Status
* Message Read Receipts
* File Sharing
* User Profiles
* Group Administration
* Message Reactions

## Author

Dileep Kumar Mallela
