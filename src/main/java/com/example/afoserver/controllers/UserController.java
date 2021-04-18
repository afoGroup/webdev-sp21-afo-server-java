package com.example.afoserver.controllers;

import com.example.afoserver.models.User;
import com.example.afoserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://anifansonly.herokuapp.com"}, allowCredentials = "true")
public class UserController {

//    This will mostlikely be changed to AUTOWIRE to auto instantiate service and provide reference to service variable
//    This service will send to a database rather than internal that it is atm
    @Autowired
    UserService userService;

    @PostMapping("/api/register")
    public User register(
            @RequestBody User user,
            HttpSession session) {
        session.setAttribute("currentUser", user);
        return userService.createUser(user);
    }

    @GetMapping("/api/users")
    public List<User> findAllUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/api/user/{uid}")
    public User findUserById(
            @PathVariable("uid") Long uid) {
        return userService.findUserById(uid);
    }

//    Get User by ID? but also not?
//    @GetMapping("/api/profile")
//    public User profile(HttpSession session) {
//        User currentUser = (User)
//                session.getAttribute("currentUser");
//        return currentUser;
//    }
//
//    @GetMapping("/api/profile/{uid}")
//    public User profile(HttpSession session) {
//        User currentUser = (User)
//                session.getAttribute("currentUser");
//        return currentUser;
//    }
//
//    @GetMapping("/api/logout")
//    public void logout
//            (HttpSession session) {
//        session.invalidate();
//    }
//
//    @GetMapping("/api/login/{uid}/{p}")
//    public User login(
//            @PathVariable("uid") String username,
//            @PathVariable("p") String password,
//            HttpSession session) {
//        for (User user : users) {
//            if( user.getUsername().equals(username)
//                    && user.getPassword().equals(password)) {
//                session.setAttribute("currentUser", user);
//                return user;
//            }
//        }
//        return null;
//    }
}
