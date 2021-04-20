package com.example.afoserver.controllers;

import com.example.afoserver.models.Club;
import com.example.afoserver.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://anifansonly.herokuapp.com"}, allowCredentials = "true")
public class ClubController {
    @Autowired
    ClubService groupService;

    @PostMapping("/api/group/new")
    public Club newClub(
            @RequestBody Club club,
            HttpSession session) {
//        User currentUser = new User(3l, "noExtraOnlyBareMin", "password4", "otaku");
//        User currentUser = (User) session.getAttribute("currentUser");
//        String usertype = currentUser.getUsertype();
//        if (usertype.equals("weeb")) {
//            return null;
//        }
//        group.createNewGroup(currentUser);
        return groupService.createClub(club);
    }

    @GetMapping("/api/groups")
    public List<Club> findAllClubs() {
        return groupService.findAllClubs();
    }

}
