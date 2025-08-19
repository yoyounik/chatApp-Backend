package com.substring.chat.chat_app_backend.services;

import com.substring.chat.chat_app_backend.entities.Room;
import com.substring.chat.chat_app_backend.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room findByRoomId(String roomId){
        Room byRoomId = roomRepository.findByRoomId(roomId);
        return byRoomId;
    }

    public Room saveNewRoomById(Room room){
        return roomRepository.save(room);
    }

}
