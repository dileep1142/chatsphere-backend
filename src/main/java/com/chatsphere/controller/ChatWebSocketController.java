package com.chatsphere.controller;

import com.chatsphere.dto.ChatMessageRequest;
import com.chatsphere.dto.SendMessageRequest;
import com.chatsphere.model.Message;
import com.chatsphere.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class ChatWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;

    public ChatWebSocketController(
            SimpMessagingTemplate messagingTemplate,
            MessageService messageService
    ) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/chat.send")
    public void sendMessage(ChatMessageRequest request) {

        SendMessageRequest saveRequest = new SendMessageRequest();
        saveRequest.setRoomId(request.getRoomId());
        saveRequest.setContent(request.getContent());

        Message savedMessage = messageService.sendMessage(
                saveRequest,
                request.getEmail()
        );

        messagingTemplate.convertAndSend(
                "/topic/room/" + request.getRoomId(),
                savedMessage
        );
    }

    @MessageMapping("/chat.typing")
    public void typing(ChatMessageRequest request) {

        messagingTemplate.convertAndSend(
                "/topic/typing/" + request.getRoomId(),
                Map.of(
                        "roomId", request.getRoomId(),
                        "username", request.getUsername()
                )
        );
    }
}