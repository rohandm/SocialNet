package com.kodebee.socialnet.userposts.repository;

import com.kodebee.socialnet.userposts.model.UserPost;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserPostsRepository extends CassandraRepository<UserPost, Long> {
    List<UserPost> findByUserId(long userId);

}
