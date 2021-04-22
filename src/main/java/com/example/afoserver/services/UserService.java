package com.example.afoserver.services;

import com.example.afoserver.models.User;
import com.example.afoserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    Do I need to set all? Or if the Request body includes all the info about the user can I just pass and save?
    public int updateUser(Long userId, User newUser) {
       User originalUser = userRepository.findById(userId).get();

       try {
           originalUser.setPassword(newUser.getPassword());
           originalUser.setUsertype(newUser.getUsertype());
           originalUser.setEmail(newUser.getEmail());
           originalUser.setTwitter(newUser.getTwitter());
           originalUser.setInstagram(newUser.getInstagram());
           originalUser.setPictureURL(newUser.getPictureURL());
           originalUser.setBio(newUser.getBio());

           userRepository.save(originalUser);
           return 0;
       }
       catch (Exception e) {
           return 1;
       }
    }

    public int deleteUser(Long userId) {
        try {
            userRepository.deleteById(userId);
            return 0;
        }
        catch (Exception e) {
            return 1;
        }
    }
}
