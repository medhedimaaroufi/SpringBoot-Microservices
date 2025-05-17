package tn.ensit.engagementservice.Like.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.engagementservice.Like.entities.Like;
import tn.ensit.engagementservice.Post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPost(Post post);
}
