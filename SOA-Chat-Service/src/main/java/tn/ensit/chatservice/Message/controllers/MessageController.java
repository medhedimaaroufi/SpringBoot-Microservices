package tn.ensit.chatservice.Message.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.ensit.chatservice.Message.dto.MessageDto;
import tn.ensit.chatservice.Message.entities.Message;
import tn.ensit.chatservice.Message.services.MessageService;
import tn.ensit.chatservice.Message.clients.UserClient;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService messageService;

    private final UserClient userClient;

    public MessageController(MessageService messageService, UserClient userClient) {
        this.messageService = messageService;
        this.userClient = userClient;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> createMessage(@RequestBody MessageDto dto) {
        Message savedMessage = messageService.saveMessage(dto);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/between/{senderId}/{receiverId}")
    public ResponseEntity<List<Message>> getMessagesBetween(@PathVariable Long senderId, @PathVariable Long receiverId) {
        Long sender = userClient.findById(senderId);
        Long receiver = userClient.findById(receiverId);
        List<Message> messages = messageService.getMessagesBetween(sender, receiver);
        return ResponseEntity.ok(messages);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        var message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}