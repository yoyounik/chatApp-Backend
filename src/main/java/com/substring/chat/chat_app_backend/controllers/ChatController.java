package com.substring.chat.chat_app_backend.controllers;

import java.time.LocalDateTime;

import com.substring.chat.chat_app_backend.config.AppConstants;
import com.substring.chat.chat_app_backend.entities.Message;
import com.substring.chat.chat_app_backend.entities.Room;
import com.substring.chat.chat_app_backend.playload.MessageRequest;
import com.substring.chat.chat_app_backend.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", AppConstants.FRONT_END_BASE_URL}, allowCredentials = "true")
public class ChatController {
    private RoomService roomService;

    public ChatController(RoomService roomService) {
        this.roomService = roomService;
    }

    // REST endpoint for creating room
    @PostMapping("/api/v1/rooms")
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveNewRoomById(room);
    }

    // REST endpoint for joining room
    @GetMapping("/api/v1/rooms/{roomId}")
    public Room joinRoom(@PathVariable String roomId) {
        return roomService.findByRoomId(roomId);
    }

    //for sending and receiving messages (WebSocket)
    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")   //subscribe
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) {

        Room room = roomService.findByRoomId(request.getRoomId());
        Message message = new Message(request.getSender(), request.getContent());

        if(room != null){
            room.getMessages().add(message);
            roomService.saveNewRoomById(room);
        }else{
            throw new RuntimeException("Room not found!!");
        }

        return message;
    }
}