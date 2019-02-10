package com.kodebee.socialnet.wallposts.service;

import com.kodebee.socialnet.wallposts.model.WallPost;
import com.kodebee.socialnet.wallposts.repository.WallPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallPostsServiceImpl implements WallPostsService{

    @Autowired
    WallPostsRepository wallPostsRepository;

    @Override
    public List<WallPost> getWallPosts(long userId) {
        return wallPostsRepository.findByUserId(userId);
    }

    @Override
    public boolean createWallPosts(WallPost wallPost) {
        wallPostsRepository.save(wallPost);
        return true;
    }

    @Override
    public boolean updateWallPosts(WallPost wallPost) {
        wallPostsRepository.save(wallPost);
        return true;
    }

    @Override
    public boolean deleteWallPosts(WallPost wallPost) {
        wallPostsRepository.save(wallPost);
        return true;
    }

}
