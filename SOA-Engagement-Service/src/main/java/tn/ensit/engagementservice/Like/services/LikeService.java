package tn.ensit.engagementservice.Like.services;

import tn.ensit.engagementservice.Clients.UserClient;
import tn.ensit.engagementservice.Like.entities.Like;
import tn.ensit.engagementservice.Like.repositories.LikeRepository;
import tn.ensit.engagementservice.Post.entities.Post;
import org.springframework.stereotype.Service;
import tn.ensit.engagementservice.Post.services.PostService;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository repository;

    private final PostService postService;

    private final UserClient userClient;

    public LikeService(LikeRepository repository, PostService postService, UserClient userClient) {
        this.repository = repository;
        this.postService = postService;
        this.userClient = userClient;
    }

    public Like likePost(Long userId, Long postId) {
        Long user = userClient.findById(userId);
        Post post = postService.findById(postId);
        return repository.save(
            new Like(user, post)
        );
    }

    public List<Like> getLikesByPost(Long postId) {
        Post post = postService.findById(postId);
        return repository.findByPost(post);
    }
}