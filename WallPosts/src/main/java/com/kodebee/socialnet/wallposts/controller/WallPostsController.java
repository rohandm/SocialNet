package com.kodebee.socialnet.wallposts.controller;

import com.kodebee.socialnet.wallposts.model.WallPost;
import com.kodebee.socialnet.wallposts.service.WallPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallposts")
public class WallPostsController {

    @Autowired
    WallPostsService wallPostsService;
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public List<WallPost> getWallPosts(@RequestParam(name = "uid") long uid){
        return wallPostsService.getWallPosts(uid);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean createWallPost(@RequestBody WallPost wallPost){
        return wallPostsService.createWallPosts(wallPost);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public boolean updateWallPost(@RequestBody WallPost wallPost){
        return wallPostsService.updateWallPosts(wallPost);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public boolean deleteWallPost(@RequestBody WallPost wallPost){
        return wallPostsService.deleteWallPosts(wallPost);
    }
}
