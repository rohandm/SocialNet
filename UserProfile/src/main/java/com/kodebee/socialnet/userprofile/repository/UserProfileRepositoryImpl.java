package com.kodebee.socialnet.userprofile.repository;

import com.kodebee.socialnet.userprofile.model.User;
import com.redislabs.redisgraph.Record;
import com.redislabs.redisgraph.RedisGraphAPI;
import com.redislabs.redisgraph.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserProfileRepositoryImpl implements UserProfileRepository {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static Logger logger = LoggerFactory.getLogger(UserProfileRepositoryImpl.class);
    @Value("${redis.graph.name}")
    private String graphDBName;
    @Value("${redis.graph.cluster-name}")
    private String clusterName;
    @Value("${redis.graph.port}")
    private int port;

    @Override
    public User findByUid(long uid) {
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        ResultSet resultSet = redisGraphAPI.query("MATCH (user:User) WHERE ID(user) = "+uid + " "+
                "RETURN id(user), user.firstName, user.lastName, user.name, user.dataOfBirth");
        if(resultSet.hasNext()){
            return convertGraphRecordToUserProfile(resultSet.next());
        }
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        ResultSet resultSet = redisGraphAPI.query("MATCH (user:User {name: '"+name+"'}) " +
                "RETURN id(user), user.firstName, user.lastName, user.name, user.dataOfBirth");
        List<User> results = new ArrayList<>();
        while(resultSet.hasNext()){
            results.add(convertGraphRecordToUserProfile(resultSet.next()));
        }
        return results;
    }

    @Override
    public List<User> findAllContactsByUid(long uid) {
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        ResultSet resultSet = redisGraphAPI.query("MATCH (user:User)-[:IS_FRIENDS_WITH]->(user1:User {uid: '"+uid+"'}) " +
                "RETURN user.uid, user.firstName, user.lastName, user.name, user.dataOfBirth");
        List<User> contacts = new ArrayList<>();
        while(resultSet.hasNext()){
            contacts.add(convertGraphRecordToUserProfile(resultSet.next()));
        }
        return contacts;
    }

    @Override
    public boolean create(User user) {
        logger.info("Entering save {}", user.getName());
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        redisGraphAPI.query("CREATE (:User{" +
                "uid:'"+user.getUid()+"'," +
                "firstName:'"+user.getFirstName()+"'," +
                "lastName:'"+user.getLastName()+"'," +
                "name:'"+user.getName()+"'," +
                "dateOfBirth:'"+format.format(user.getDateOfBirth())+"'," +
                "uid:'"+user.getUid()+"'})");
        return true;
    }

    @Override
    public boolean update(User user) {
        logger.info("Entering update {}", user.getName());
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        redisGraphAPI.query("MATCH (u:User) WHERE id(u)="+user.getUid() +
                "SET u += {firstName:'"+user.getFirstName()+"'," +
                "lastName:'"+user.getLastName()+"'," +
                "name:'"+user.getName()+"'," +
                "dateOfBirth:'"+format.format(user.getDateOfBirth())+"'," +
                "uid:'"+user.getUid()+"'}");
        return true;
    }

    @Override
    public boolean delete(User user) {
        logger.info("Entering delete {}", user.getName());
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        redisGraphAPI.query("MATCH (u)-[r]-() WHERE id(u)="+user.getUid() +
                " DELETE u, r");
        return true;
    }


    @Override
    public boolean addFriend(long id1, long id2) {
        RedisGraphAPI redisGraphAPI = new RedisGraphAPI(graphDBName, clusterName, port);
        redisGraphAPI.query("MATCH (u1:User), (u2:User) " +
                "WHERE id(u1) = '"+id1+"' AND id(u2) = '"+id2+"' " +
                "CREATE (u1)-[:IS_FRIENDS_WITH]->(u2)");
        return true;
    }

    private User convertGraphRecordToUserProfile(Record record){
        User user = new User();
        user.setUid(Long.valueOf(getValue(record, "id(user)")));
        user.setFirstName(getValue(record, "user.firstName"));
        user.setLastName(getValue(record, "user.lastName"));
        String storedDate = getValue(record, "user.dateOfBirth");
        if(storedDate != null && !"".equals(storedDate.trim())) {
            try {
                user.setDateOfBirth(format.parse(storedDate));
            } catch (Exception e) {
                logger.error("Error occured while retrieving date {}", record.getString("user.dateOfBirth"), e);
            }
        }
        return user;
    }

    private String getValue(Record record, String key){
        if(record.containsKey(key)){
            return record.getString(key);
        }
        return null;
    }
}
