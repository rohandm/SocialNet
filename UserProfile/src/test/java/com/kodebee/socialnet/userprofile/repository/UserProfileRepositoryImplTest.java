package com.kodebee.socialnet.userprofile.repository;

import com.kodebee.socialnet.userprofile.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileRepositoryImplTest {

    private static Logger logger = LoggerFactory.getLogger(UserProfileRepositoryImplTest.class);
    @Autowired
    UserProfileRepository userProfileRepository;

    @Test
    public void findByUid() {
        User user = userProfileRepository.findByUid(0);
        logger.info("{}", user);
    }

    @Test
    public void findByName() {
        List<User> userList = userProfileRepository.findByName("Harry Potter");
        logger.info("{}", userList);
    }

    @Test
    public void findAllContactsByUid() {
        List<User> contactList = userProfileRepository.findAllContactsByUid(4);
        logger.info("{}", contactList);
    }

    @Test
    public void create() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setFirstName("Harry");
        user.setLastName("Potter");
        user.setDateOfBirth(format.parse("2000-01-08"));
        user.setCity("Dallas");
        userProfileRepository.create(user);
    }

    @Test
    public void update() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setUid(3);
        user.setFirstName("Harry1");
        user.setLastName("Potter");
        user.setDateOfBirth(format.parse("2000-01-08"));
        user.setCity("Dallas");
        userProfileRepository.update(user);
    }

    @Test
    public void addFriend() {
        userProfileRepository.addFriend(2, 3);
    }
}