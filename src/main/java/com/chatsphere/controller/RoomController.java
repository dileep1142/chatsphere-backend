package com.chatsphere.controller;

import com.chatsphere.dto.CreateRoomRequest;
import com.chatsphere.model.Room;
import com.chatsphere.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<Room> createRoom(
            @Valid @RequestBody CreateRoomRequest request,
            Authentication authentication
    ) {

        Room room = roomService.createRoom(
                request,
                authentication.getName()
        );

        return ResponseEntity.ok(room);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }
}