package tn.ensit.engagementservice.Comment.services;

import tn.ensit.engagementservice.Clients.UserClient;
import tn.ensit.engagementservice.Comment.entities.*;
import tn.ensit.engagementservice.Comment.repositories.*;
import org.springframework.stereotype.Service;
import tn.ensit.engagementservice.Post.entities.Post;
import tn.ensit.engagementservice.Post.services.PostService;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;

    private final PostService postService;

    private final UserClient userClient;

    public CommentService(CommentRepository repository, PostService postService, UserClient userClient) {
        this.repository = repository;
        this.postService = postService;
        this.userClient = userClient;
    }

    public Comment addComment(Long commenterId, Long postId, String content) {
        Long commenter = userClient.findById(commenterId);
        Post post = postService.findById(postId);
        return repository.save(
            new Comment(commenter, post, content)
        );
    }

    public List<Comment> getCommentsByPost(Long postId) {
        Post post = postService.findById(postId);
        return repository.findByPost(post);
    }
}
