package tn.ensit.userservice.user.entities;

import jakarta.persistence.*;
import tn.ensit.userservice.profile.entities.Profile;

import java.util.ArrayList;
import java.util.List;

// This annotation is required to declare an entity (database table)
@Entity
// This annotation is used to rename the created table
@Table(name = "users")
public class User {

    // This annotation is used to declare the entity's id and it is required
    @Id
    // This annotation to ask Hibernate to generate the id automatically using a specific generation strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    private List<Long> sentMessages = new ArrayList<>();

    private List<Long> receivedMessages = new ArrayList<>();

    private List<Long> posts = new ArrayList<>();
    protected User() {
    }

    public User(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Long> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Long> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Long> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Long> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Long> getPosts() {
        return posts;
    }

    public void setPosts(List<Long> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}