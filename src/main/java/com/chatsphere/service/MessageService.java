package com.chatsphere.service;

import com.chatsphere.dto.SendMessageRequest;
import com.chatsphere.model.Message;
import com.chatsphere.model.User;
import com.chatsphere.repository.MessageRepository;
import com.chatsphere.repository.RoomRepository;
import com.chatsphere.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public MessageService(
            MessageRepository messageRepository,
            RoomRepository roomRepository,
            UserRepository userRepository
    ) {
        this.messageRepository = messageRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public Message sendMessage(SendMessageRequest request, String senderEmail) {

        roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        User user = userRepository.findByEmail(senderEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Message message = new Message();
        message.setRoomId(request.getRoomId());
        message.setSenderEmail(user.getEmail());
        message.setSenderUsername(user.getUsername());
        message.setContent(request.getContent());

        return messageRepository.save(message);
    }

    public List<Message> getMessagesByRoom(Long roomId) {

        roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return messageRepository.findByRoomIdOrderBySentAtAsc(roomId);
    }
}