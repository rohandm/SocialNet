package com.kodebee.socialnet.usercomments.repository;

import com.kodebee.socialnet.usercomments.model.UserComment;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserCommentsRepository extends CassandraRepository<UserComment, Long> {
    List<UserComment> findByUserId(long userId);

}
