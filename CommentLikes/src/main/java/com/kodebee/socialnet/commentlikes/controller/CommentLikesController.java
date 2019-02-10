package com.kodebee.socialnet.commentlikes.controller;

import com.kodebee.socialnet.commentlikes.model.CommentLike;
import com.kodebee.socialnet.commentlikes.service.CommentLikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentlikes")
public class CommentLikesController {

    @Autowired
    CommentLikesService commentLikesService;
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public List<CommentLike> getCommentLikes(@RequestParam(name = "uid") long uid){
        return commentLikesService.getCommentLikes(uid);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public boolean createCommentLike(@RequestBody CommentLike commentLike){
        return commentLikesService.createCommentLikes(commentLike);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public boolean updateCommentLike(@RequestBody CommentLike commentLike){
        return commentLikesService.updateCommentLikes(commentLike);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public boolean deleteCommentLike(@RequestBody CommentLike commentLike){
        return commentLikesService.deleteCommentLikes(commentLike);
    }
}
