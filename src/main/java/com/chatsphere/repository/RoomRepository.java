package com.chatsphere.repository;

import com.chatsphere.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomName(String roomName);

    boolean existsByRoomName(String roomName);
}