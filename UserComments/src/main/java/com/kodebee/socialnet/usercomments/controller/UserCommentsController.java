package com.kodebee.socialnet.usercomments.controller;

import com.kodebee.socialnet.usercomments.model.UserComment;
import com.kodebee.socialnet.usercomments.service.UserCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usercomments")
public class UserCommentsController {

    @Autowired
    UserCommentsService userCommentsService;
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public List<UserComment> getUserComments(@RequestParam(name = "uid") long uid){
        return userCommentsService.getUserComments(uid);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean createUserComment(@RequestBody UserComment userComment){
        return userCommentsService.createUserComments(userComment);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public boolean updateUserComment(@RequestBody UserComment userComment){
        return userCommentsService.updateUserComments(userComment);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public boolean deleteUserComment(@RequestBody UserComment userComment){
        return userCommentsService.deleteUserComments(userComment);
    }
}
