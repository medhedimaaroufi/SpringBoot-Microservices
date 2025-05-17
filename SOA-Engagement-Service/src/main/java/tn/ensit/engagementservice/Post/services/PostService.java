package tn.ensit.engagementservice.Post.services;

import tn.ensit.engagementservice.Post.entities.Post;
import tn.ensit.engagementservice.Post.repositories.PostRepository;
import tn.ensit.engagementservice.Clients.UserClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    private final UserClient userClient;

    public PostService(PostRepository repository, UserClient userClient) {
        this.repository = repository;
        this.userClient = userClient;
    }

    public Post createPost(Long authorId, String content) {
        Long author = userClient.findById(authorId);
        Post post = new Post(author, content);
        return repository.save(post);
    }

    public List<Post> getPostsByAuthor(Long authorId) {
        Long author = userClient.findById(authorId);
        return repository.findByAuthor(author);
    }

    public Post findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}