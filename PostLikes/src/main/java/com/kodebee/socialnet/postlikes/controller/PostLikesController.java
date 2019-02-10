package com.kodebee.socialnet.postlikes.controller;

import com.kodebee.socialnet.postlikes.model.PostLike;
import com.kodebee.socialnet.postlikes.service.PostLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postlikes")
public class PostLikesController {

    @Autowired
    PostLikesService postLikesService;
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public List<PostLike> getPostLikes(@RequestParam(name = "uid") long uid){
        return postLikesService.getPostLikes(uid);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean createPostLike(@RequestBody PostLike postLike){
        return postLikesService.createPostLikes(postLike);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public boolean updatePostLike(@RequestBody PostLike postLike){
        return postLikesService.updatePostLikes(postLike);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public boolean deletePostLike(@RequestBody PostLike postLike){
        return postLikesService.deletePostLikes(postLike);
    }
}
