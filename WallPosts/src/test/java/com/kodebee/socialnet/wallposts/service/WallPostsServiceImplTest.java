package com.kodebee.socialnet.wallposts.service;

import com.kodebee.socialnet.wallposts.model.WallPost;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WallPostsServiceImplTest {

    @Autowired
    WallPostsService wallPostsService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getWallPosts() {
        wallPostsService.getWallPosts(3);
    }

    @Test
    public void createWallPosts() {
        WallPost wallPost = new WallPost();
    }

    @Test
    public void updateWallPosts() {
    }

    @Test
    public void deleteWallPosts() {
    }
}