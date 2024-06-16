package com.venkat.multiDatasource.post.service;

import com.venkat.multiDatasource.post.model.Post;
import com.venkat.multiDatasource.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> getById(Integer id){
        return postRepository.findById(id);
    }

    public Post save(Post user){
        return postRepository.save(user);
    }

    public Post update(Post user){
        return postRepository.save(user);
    }

    public String deleteById(Integer id){
        postRepository.deleteById(id);
        return "User is deleted...";
    }
}
