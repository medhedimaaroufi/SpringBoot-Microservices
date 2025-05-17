package tn.ensit.chatservice.Message.services;

import org.springframework.stereotype.Service;
import tn.ensit.chatservice.Message.clients.UserClient;
import tn.ensit.chatservice.Message.dto.MessageDto;
import tn.ensit.chatservice.Message.entities.Message;
import tn.ensit.chatservice.Message.repositories.MessageRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MessageService {

    private static final Logger LOGGER = Logger.getLogger(MessageService.class.getName());

    private final MessageRepository messageRepository;
    private final UserClient userClient;

    public MessageService(MessageRepository messageRepository, UserClient userClient) {
        this.messageRepository = messageRepository;
        this.userClient = userClient;
    }

    public Message saveMessage(MessageDto dto) {
        Optional<Long> user = userClient.getOneUser(dto.getReceiverId());
        if(user.isPresent()) {
            Message message = new Message(dto.getChannelId(), Long.parseLong(user.get().toString()));
            return messageRepository.save(message);
        } else {
            String message = "Error while saving Message, user with id %d does not exist.".formatted(dto.getReceiverId());
            LOGGER.severe(message);
            throw new RuntimeException(message);
        }
    }
    public List<Message> getMessagesBetween(Long sender, Long receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}