package com.kodebee.socialnet.postlikes.repository;

import com.kodebee.socialnet.postlikes.model.PostLike;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface PostLikesRepository extends CassandraRepository<PostLike, Long> {
    List<PostLike> findByUserId(long userId);

}
