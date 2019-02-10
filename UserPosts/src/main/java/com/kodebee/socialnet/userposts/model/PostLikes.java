package com.kodebee.socialnet.userposts.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.Date;

public class PostLikes {
    @PrimaryKeyColumn(
            name = "userId",
            ordinal = 0,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING)
    private long userId;
    @PrimaryKeyColumn(
            name = "postId",
            ordinal = 1,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING)
    private long postId;
    @Column
    private long likerUserId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getLikerUserId() {
        return likerUserId;
    }

    public void setLikerUserId(long likerUserId) {
        this.likerUserId = likerUserId;
    }
}
