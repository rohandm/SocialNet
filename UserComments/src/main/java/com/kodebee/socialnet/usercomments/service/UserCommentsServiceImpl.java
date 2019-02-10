package com.kodebee.socialnet.usercomments.service;

import com.kodebee.socialnet.usercomments.model.UserComment;
import com.kodebee.socialnet.usercomments.repository.UserCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentsServiceImpl implements UserCommentsService{

    @Autowired
    UserCommentsRepository userCommentsRepository;

    @Override
    public List<UserComment> getUserComments(long userId) {
        return userCommentsRepository.findByUserId(userId);
    }

    @Override
    public boolean createUserComments(UserComment userComment) {
        userCommentsRepository.save(userComment);
        return true;
    }

    @Override
    public boolean updateUserComments(UserComment userComment) {
        userCommentsRepository.save(userComment);
        return true;
    }

    @Override
    public boolean deleteUserComments(UserComment userComment) {
        userCommentsRepository.save(userComment);
        return true;
    }
}
