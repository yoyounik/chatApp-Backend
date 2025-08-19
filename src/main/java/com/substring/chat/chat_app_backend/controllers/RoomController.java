package com.substring.chat.chat_app_backend.controllers;

import java.util.List;

import com.substring.chat.chat_app_backend.config.AppConstants;
import com.substring.chat.chat_app_backend.entities.Message;
import com.substring.chat.chat_app_backend.entities.Room;
import com.substring.chat.chat_app_backend.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(AppConstants.FRONT_END_BASE_URL)
public class RoomController {

    @Autowired
    private RoomService roomService;

    //create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        if(roomService.findByRoomId(roomId) != null){
            // room already exist
            return ResponseEntity.badRequest().body("Room already exist");
        }

        //create new room
        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomService.saveNewRoomById(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

    //get room: trying to join room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        Room room = roomService.findByRoomId(roomId);

        if(room == null){
            return ResponseEntity.badRequest().body("Room not found!!");
        }

        return ResponseEntity.ok(room);
    }

    //get messages of room
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "20", required = false) int size
    ){
        Room room = roomService.findByRoomId(roomId);
        if(room == null){
            return ResponseEntity.badRequest().build();
        }

//        List<Message> messages = room.getMessages();
//        return ResponseEntity.ok(messages);     This was simply to get message

        //But we doing pagination also

        List<Message> messages = room.getMessages();

        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        List<Message> paginatedMessage = messages.subList(start, end);

        return ResponseEntity.ok(paginatedMessage);
    }
}
