package com.kodebee.socialnet.userposts.service;

import com.kodebee.socialnet.userposts.model.UserPost;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserPostsServiceImplTest {

    @Autowired
    UserPostsService userPostsService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUserPosts() {
        userPostsService.getUserPosts(3);
    }

    @Test
    public void createUserPosts() {
        UserPost userPost = new UserPost();
    }

    @Test
    public void updateUserPosts() {
    }

    @Test
    public void deleteUserPosts() {
    }
}