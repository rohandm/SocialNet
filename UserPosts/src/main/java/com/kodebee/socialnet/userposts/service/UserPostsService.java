package com.kodebee.socialnet.userposts.service;

import com.kodebee.socialnet.userposts.model.UserPost;

import java.util.List;

public interface UserPostsService {
    public List<UserPost> getUserPosts(long uid);
    public boolean createUserPosts(UserPost userPost);
    public boolean updateUserPosts(UserPost userPost);
    public boolean deleteUserPosts(UserPost userPost);
}
