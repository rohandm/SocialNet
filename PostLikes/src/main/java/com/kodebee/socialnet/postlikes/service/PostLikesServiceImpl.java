package com.kodebee.socialnet.postlikes.service;

import com.kodebee.socialnet.postlikes.model.PostLike;
import com.kodebee.socialnet.postlikes.repository.PostLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikesServiceImpl implements PostLikesService{
    @Autowired
    PostLikesRepository postLikesRepository;
    @Override
    public List<PostLike> getPostLikes(long userId) {
        return postLikesRepository.findByUserId(userId);
    }


    @Override
    public boolean createPostLikes(PostLike postLike) {
        postLikesRepository.save(postLike);
        return true;
    }

    @Override
    public boolean updatePostLikes(PostLike postLike) {
        postLikesRepository.save(postLike);
        return true;
    }

    @Override
    public boolean deletePostLikes(PostLike postLike) {
        postLikesRepository.save(postLike);
        return true;
    }
}
