package tn.ensit.engagementservice.Comment.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.engagementservice.Comment.entities.Comment;
import tn.ensit.engagementservice.Post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
