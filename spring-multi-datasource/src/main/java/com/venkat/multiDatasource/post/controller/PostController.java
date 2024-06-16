package com.venkat.multiDatasource.post.controller;

import com.venkat.multiDatasource.post.model.Post;
import com.venkat.multiDatasource.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id){
        Optional<Post> post = postService.getById(id);
        Post userObj = post.get();
        return ResponseEntity.ok(userObj);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post user){
        return ResponseEntity.ok(postService.save(user));
    }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody Post user){
        return ResponseEntity.ok(postService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Integer id){
        return ResponseEntity.ok(postService.deleteById(id));
    }
}
