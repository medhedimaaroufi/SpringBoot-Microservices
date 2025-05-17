package tn.ensit.engagementservice.Comment.entities;

import jakarta.persistence.*;
import tn.ensit.engagementservice.Post.entities.Post;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    private Long commenter;

    private String content;
    private LocalDateTime timestamp;

    public Comment() {
    }

    public Comment(Long commenter, Post post, String content) {
        this.commenter = commenter;
        this.post = post;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getCommenter() {
        return commenter;
    }

    public void setCommenter(Long commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + post.getId() +
                ", commenterId=" + commenter +
                ", content='" + content + '\'' +
                '}';
    }
}