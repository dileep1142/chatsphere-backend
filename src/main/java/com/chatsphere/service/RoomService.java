package com.chatsphere.service;

import com.chatsphere.dto.CreateRoomRequest;
import com.chatsphere.model.Room;
import com.chatsphere.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(CreateRoomRequest request, String createdBy) {

        if (roomRepository.existsByRoomName(request.getRoomName())) {
            throw new RuntimeException("Room already exists");
        }

        Room room = new Room();
        room.setRoomName(request.getRoomName());
        room.setCreatedBy(createdBy);

        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}