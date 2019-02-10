package com.kodebee.socialnet.wallposts.repository;

import com.kodebee.socialnet.wallposts.model.WallPost;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface WallPostsRepository extends CassandraRepository<WallPost, Long> {
    List<WallPost> findByUserId(long userId);

}
