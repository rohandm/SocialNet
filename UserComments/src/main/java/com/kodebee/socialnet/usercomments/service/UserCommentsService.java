package com.kodebee.socialnet.usercomments.service;

import com.kodebee.socialnet.usercomments.model.UserComment;

import java.util.List;

public interface UserCommentsService {
    public List<UserComment> getUserComments(long uid);
    public boolean createUserComments(UserComment userComment);
    public boolean updateUserComments(UserComment userComment);
    public boolean deleteUserComments(UserComment userComment);
}
