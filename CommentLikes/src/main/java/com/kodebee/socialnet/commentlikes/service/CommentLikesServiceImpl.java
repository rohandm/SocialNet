package com.kodebee.socialnet.commentlikes.service;

import com.kodebee.socialnet.commentlikes.model.CommentLike;
import com.kodebee.socialnet.commentlikes.repository.CommentLikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLikesServiceImpl implements CommentLikesService{
    @Autowired
    CommentLikesRepository commentLikesRepository;
    @Override
    public List<CommentLike> getCommentLikes(long userId) {
        return commentLikesRepository.findByUserId(userId);
    }


    @Override
    public boolean createCommentLikes(CommentLike commentLike) {
        commentLikesRepository.save(commentLike);
        return true;
    }

    @Override
    public boolean updateCommentLikes(CommentLike commentLike) {
        commentLikesRepository.save(commentLike);
        return true;
    }

    @Override
    public boolean deleteCommentLikes(CommentLike commentLike) {
        commentLikesRepository.save(commentLike);
        return true;
    }
}
