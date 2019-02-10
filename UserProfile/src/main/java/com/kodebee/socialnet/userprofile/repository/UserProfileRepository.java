package com.kodebee.socialnet.userprofile.repository;

import com.kodebee.socialnet.userprofile.model.User;

import java.util.List;

public interface UserProfileRepository {
    User findByUid(long uid);
    List<User> findByName(String name);
    List<User> findAllContactsByUid(long uid);
    boolean create(User user);
    boolean update(User user);
    boolean delete(User user);
    boolean addFriend(long id1, long id2);
}
