package com.kodebee.socialnet.userposts.service;

import com.kodebee.socialnet.userposts.model.UserPost;
import com.kodebee.socialnet.userposts.repository.UserPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPostsServiceImpl implements UserPostsService{

    @Autowired
    UserPostsRepository userPostsRepository;

    @Override
    public List<UserPost> getUserPosts(long userId) {
        return userPostsRepository.findByUserId(userId);
    }

    @Override
    public boolean createUserPosts(UserPost userPost) {
        userPostsRepository.save(userPost);
        return true;
    }

    @Override
    public boolean updateUserPosts(UserPost userPost) {
        userPostsRepository.save(userPost);
        return true;
    }

    @Override
    public boolean deleteUserPosts(UserPost userPost) {
        userPostsRepository.save(userPost);
        return true;
    }

}
