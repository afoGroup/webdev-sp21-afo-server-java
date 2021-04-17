package com.example.afoserver.controllers;

import com.example.afoserver.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<User> users = new ArrayList<User>();
    @GetMapping("/api/register/{u}/{p}/{t}")
    public User register(
            @PathVariable("u") String username,
            @PathVariable("p") String password,
            @PathVariable("t") String type,
            HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUsertype(type);
        session.setAttribute("currentUser", user);
        users.add(user);
        return user;
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @GetMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }

    @GetMapping("/api/login/{u}/{p}")
    public User login(
            @PathVariable("u") String username,
            @PathVariable("p") String password,
            HttpSession session) {
        for (User user : users) {
            if( user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                session.setAttribute("currentUser", user);
                return user;
            }
        }
        return null;
    }
}
