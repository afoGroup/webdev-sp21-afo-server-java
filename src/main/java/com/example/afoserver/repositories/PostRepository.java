package com.example.afoserver.repositories;

import com.example.afoserver.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
