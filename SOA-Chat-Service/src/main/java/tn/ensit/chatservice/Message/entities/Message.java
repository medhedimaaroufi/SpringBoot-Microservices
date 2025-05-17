package tn.ensit.chatservice.Message.entities;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channelId;

    private Long sender;

    private Long receiver;
    public Message() {}

    public Message(String channelId, Long sender, Long receiver) {
        this.channelId = channelId;
        this.sender = sender;
        this.receiver = receiver;
    }
    public Message(String channelId, Long receiver) {
        this.channelId = channelId;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}