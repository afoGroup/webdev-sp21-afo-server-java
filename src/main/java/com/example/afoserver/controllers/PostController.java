package com.example.afoserver.controllers;

import com.example.afoserver.models.Post;
import com.example.afoserver.models.User;
import com.example.afoserver.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://anifansonly.herokuapp.com"}, allowCredentials = "true")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/api/groups/{gid}/posts")
    public Post createPost(
            @RequestBody Post post,
            @PathVariable("gid") Long clubId,
            HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
// Todo: Check if user in club... Needed!!! Check UserClub table somehow... Might not be necessary as users who arent part of the club won't see this functionality?
        String username = currentUser.getUsername();
        post.setUsername(username);
        post.setCreatedOn(new Timestamp(System.currentTimeMillis()));
        return postService.createPost(post);
    }

    //    TODO: Do i, no groups api by id returns posts too? Need to write accompanying query in PostInterface
//    @GetMapping("/api/groups/{gid}/posts")
//    public Post findPostsForClubs(
//            @PathVariable("gid") Long clubId) {
//        return postService.findPostsForClub(clubId);
//    }

    @GetMapping("/api/posts")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/api/posts/{pid}")
    public Post findPostById(
            @PathVariable("pid") Long postId) {
        return postService.findPostById(postId);
    }

    /**
     * Deletes user and logs user out (This might need to updated to delete club from user object and userclub)
     * @param postId the id of the post
     * @return 0 if successful 1 if not
     */
   @DeleteMapping("/api/posts/{pid}")
   public int deletePost(
           @PathVariable("pid") Long postId) {
        return postService.deletePost(postId);
   }
   
}
