package com.kodebee.socialnet.wallposts.service;

import com.kodebee.socialnet.wallposts.model.WallPost;

import java.util.List;

public interface WallPostsService {
    public List<WallPost> getWallPosts(long uid);
    public boolean createWallPosts(WallPost wallPost);
    public boolean updateWallPosts(WallPost wallPost);
    public boolean deleteWallPosts(WallPost wallPost);
}
