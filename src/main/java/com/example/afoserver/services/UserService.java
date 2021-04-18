package com.example.afoserver.services;

import com.example.afoserver.models.User;
import com.example.afoserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public User findUserByCredentials(String username, String password) {
        return userRepository.findUserByCredentials(username, password);
    }
}
