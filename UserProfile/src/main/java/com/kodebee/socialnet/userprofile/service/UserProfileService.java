package com.kodebee.socialnet.userprofile.service;

import com.kodebee.socialnet.userprofile.model.User;

import java.util.List;

public interface UserProfileService {
    public User getUserProfile(long uid);
    public List<User> getUserProfilesByName(String name);
    public boolean createUserProfile(User user);
    public boolean updateUserProfile(User user);
    public boolean deleteUserProfile(User user);
    public boolean addFriend(long uid, long fuid);
}
