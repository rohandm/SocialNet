package com.kodebee.socialnet.userposts.controller;

import com.kodebee.socialnet.userposts.model.UserPost;
import com.kodebee.socialnet.userposts.service.UserPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userposts")
public class UserPostsController {

    @Autowired
    UserPostsService userPostsService;
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public List<UserPost> getUserPosts(@RequestParam(name = "uid") long uid){
        return userPostsService.getUserPosts(uid);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean createUserPost(@RequestBody UserPost userPost){
        return userPostsService.createUserPosts(userPost);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public boolean updateUserPost(@RequestBody UserPost userPost){
        return userPostsService.updateUserPosts(userPost);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public boolean deleteUserPost(@RequestBody UserPost userPost){
        return userPostsService.deleteUserPosts(userPost);
    }
}
