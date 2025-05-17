package tn.ensit.engagementservice.Like.entities;

import jakarta.persistence.*;
import tn.ensit.engagementservice.Post.entities.Post;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private LocalDateTime timestamp;

    protected Like() {
    }

    public Like(Long user, Post post) {
        this.user = user;
        this.post = post;
        this.timestamp = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post.getId() +
                '}';
    }
}