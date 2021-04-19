package com.example.afoserver.controllers;

import com.example.afoserver.models.Group;
import com.example.afoserver.models.User;
import com.example.afoserver.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://anifansonly.herokuapp.com"}, allowCredentials = "true")
public class GroupController {
    @Autowired
    GroupService groupService;

    @PostMapping("/api/group/new")
    public Group createGroup(
            @RequestBody Group group,
            HttpSession session) {
        User currentUser = new User(3l, "noExtraOnlyBareMin", "password4", "otaku")
//        User currentUser = (User) session.getAttribute("currentUser");
        Long userId = currentUser.getId();
        String usertype = currentUser.getUsertype();
        if (usertype.equals("weeb")) {
            return null;
        }
        group.createNewGroup(currentUser);
        return groupService.createGroup(group);
    }


}
