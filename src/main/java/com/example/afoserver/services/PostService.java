package com.example.afoserver.services;

import com.example.afoserver.models.Post;
import com.example.afoserver.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    public Post findPostById(Long postId) {
        return postRepository.findById(postId).get();
    }

    public int deletePost(Long postId) {
        try {
            postRepository.deleteById(postId);
            return 0;
        }
        catch (Exception e) {
            return 1;
        }
    }

}
