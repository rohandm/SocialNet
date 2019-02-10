package com.kodebee.socialnet.userprofile.service;

import com.kodebee.socialnet.userprofile.model.User;
import com.kodebee.socialnet.userprofile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    UserProfileRepository userProfileRepository;
    @Override
    public User getUserProfile(long uid) {
        return userProfileRepository.findByUid(uid);
    }

    public List<User> getUserProfilesByName(String name){
        return userProfileRepository.findByName(name);
    }

    @Override
    public boolean createUserProfile(User user) {
        return userProfileRepository.create(user);
    }

    @Override
    public boolean updateUserProfile(User user) {
        return userProfileRepository.update(user);
    }

    @Override
    public boolean deleteUserProfile(User user) {
        return userProfileRepository.delete(user);
    }

    @Override
    public boolean addFriend(long uid, long fuid) {
        return userProfileRepository.addFriend(uid, fuid);
    }
}
