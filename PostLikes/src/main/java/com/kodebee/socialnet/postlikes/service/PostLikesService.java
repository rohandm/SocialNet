package com.kodebee.socialnet.postlikes.service;

import com.kodebee.socialnet.postlikes.model.PostLike;

import java.util.List;

public interface PostLikesService {
    public List<PostLike> getPostLikes(long uid);
    public boolean createPostLikes(PostLike postLike);
    public boolean updatePostLikes(PostLike postLike);
    public boolean deletePostLikes(PostLike postLike);
}
