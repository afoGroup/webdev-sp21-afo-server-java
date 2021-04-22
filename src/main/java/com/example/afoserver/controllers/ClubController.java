package com.example.afoserver.controllers;

import com.example.afoserver.models.Club;
import com.example.afoserver.models.User;
import com.example.afoserver.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://anifansonly.herokuapp.com"}, allowCredentials = "true")
public class ClubController {
    @Autowired
    ClubService clubService;

//    Testing needed: Postman to test with sessions is hard
//    Returns null if weeb, theortically never going to happen
    @PostMapping("/api/groups/create")
    public Club createClub(
            @RequestBody Club club,
            HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        String usertype = currentUser.getUsertype();
        if (usertype.equals("weeb")) {
            return null;
        }
        club.createNewClub(currentUser);
        return clubService.createClub(club);
    }

    @GetMapping("/api/groups")
    public List<Club> findAllClubs() {
        return clubService.findAllClubs();
    }

    @GetMapping("/api/groups/{gid}")
    public Club findClubById(
            @PathVariable("gid") Long clubId) {
        return clubService.findClubById(clubId);
    }

    /**
     * For updating the group (club) information, you need to pass all the group's info
     * @return 0 if successful 1 if not
     */
    @PutMapping("/api/groups/{gid}")
    public int updateClub(
             @RequestBody Club club) {
        return clubService.updateClub(club);
    }

    /**
     * Deletes user and logs user out (This might need to updated to delete club from user object and userclub)
     * @param clubId the id of the group (club)
     * @return 0 if successful 1 if not
     */
    @DeleteMapping("/api/groups/{gid}")
    public int deleteClub(
            @PathVariable("gid") Long clubId) {
        return clubService.deleteClub(clubId);
    }



}
