package com.kodebee.socialnet.commentlikes.service;

import com.kodebee.socialnet.commentlikes.model.CommentLike;

import java.util.List;

public interface CommentLikesService {
    public List<CommentLike> getCommentLikes(long uid);
    public boolean createCommentLikes(CommentLike commentLike);
    public boolean updateCommentLikes(CommentLike commentLike);
    public boolean deleteCommentLikes(CommentLike commentLike);
}
