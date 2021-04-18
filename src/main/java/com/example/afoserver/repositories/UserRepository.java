package com.example.afoserver.repositories;

import com.example.afoserver.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM widgets WHERE username=:username", nativeQuery = true )
    public User findUserByUsername(@Param("username") String username);
}
