package com.chatsphere.controller;

import com.chatsphere.dto.SendMessageRequest;
import com.chatsphere.model.Message;
import com.chatsphere.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(
            @Valid @RequestBody SendMessageRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                messageService.sendMessage(request, authentication.getName())
        );
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Message>> getMessagesByRoom(
            @PathVariable Long roomId
    ) {
        return ResponseEntity.ok(
                messageService.getMessagesByRoom(roomId)
        );
    }
}