# ChatSphere - Real-Time Chat Application

## Overview

ChatSphere is a full-stack real-time chat application built using React.js, Spring Boot, MySQL, JWT Authentication, and WebSocket (STOMP).

Users can register, login securely, create chat rooms, send messages in real time, and view chat history across multiple devices.

---

## Features

### Authentication

* User Registration
* User Login
* JWT Token Authentication
* Protected Routes

### Chat Rooms

* Create New Rooms
* View Available Rooms
* Join Rooms

### Real-Time Messaging

* WebSocket Communication
* STOMP Protocol
* Instant Message Delivery
* Typing Indicator

### Message Management

* Message Persistence
* Chat History
* Sender Information
* Timestamp Support

### Responsive Design

* Mobile Friendly UI
* Tablet Support
* Desktop Support

---

## Tech Stack

### Frontend

* React.js
* React Router DOM
* Axios
* STOMP.js
* SockJS
* CSS3

### Backend

* Spring Boot
* Spring Security
* Spring Data JPA
* JWT Authentication
* Spring WebSocket

### Database

* MySQL

### Build Tools

* Maven
* Vite

---

## Project Structure

Backend

chat-sphere/

* controller
* service
* repository
* model
* dto
* security
* config

Frontend

chat-sphere-frontend/

* components
* pages
* services
* context
* assets

---

## Screenshots

### Login Page

(Add Screenshot)

### Register Page

(Add Screenshot)

### Chat Room

(Add Screenshot)

### Mobile View

(Add Screenshot)

---

## Installation

### Backend

```bash
cd chat-sphere
./mvnw spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

### Frontend

```bash
cd chat-sphere-frontend
npm install
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

---

## Future Enhancements

* Emoji Support
* File Sharing
* Online User Status
* Group Management
* Message Reactions
* Read Receipts

---

## Author

Mallela Dileep Kumar

GitHub:
https://github.com/dileep1142

LinkedIn:
https://www.linkedin.com/in/dileep-kumar-mallela-28b9852a7/
---

Built with React.js, Spring Boot, MySQL, JWT, and WebSocket.
