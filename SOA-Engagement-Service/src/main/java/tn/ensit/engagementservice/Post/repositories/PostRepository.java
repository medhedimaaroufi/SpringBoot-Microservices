package tn.ensit.engagementservice.Post.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.engagementservice.Post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(Long author);
}