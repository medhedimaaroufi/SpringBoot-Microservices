package tn.ensit.engagementservice.Comment.controllers;

import tn.ensit.engagementservice.Comment.dto.CommentDto;
import tn.ensit.engagementservice.Comment.entities.Comment;
import tn.ensit.engagementservice.Comment.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentService.addComment(commentDto.getCommenterId(), commentDto.getPostId(), commentDto.getContent());
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
}