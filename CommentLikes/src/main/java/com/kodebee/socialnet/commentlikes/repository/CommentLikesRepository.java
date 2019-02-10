package com.kodebee.socialnet.commentlikes.repository;

import com.kodebee.socialnet.commentlikes.model.CommentLike;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface CommentLikesRepository extends CassandraRepository<CommentLike, Long> {
    List<CommentLike> findByUserId(long userId);

}
