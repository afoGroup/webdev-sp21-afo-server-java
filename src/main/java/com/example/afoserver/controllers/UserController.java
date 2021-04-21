package com.example.afoserver.controllers;

import com.example.afoserver.models.User;
import com.example.afoserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://anifansonly.herokuapp.com"}, allowCredentials = "true")
public class UserController {

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

    /**
     * Endpoint to find user by ID used for search and routing to user profiles
     * @param uid user id
     * @return User that is looked up and their info
     */
    @GetMapping("/api/users/{uid}")
    public User findUserById(
            @PathVariable("uid") Long uid) {
        return userService.findUserById(uid);
    }

    /**
     * Endpoint to retrieve the logged in user's profile information
     * @param session current session
     * @return currentUser info about currentUser
     */
    @PostMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/api/login")
    public User login(HttpSession session, @RequestBody User user) {
        User currentUser = userService.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("currentUser", currentUser);
        return currentUser;
    }

//    @DeleteMapping("/api/users/{uid}")
//    public deleteUser(
//            @PathVariable()
//    )

}
