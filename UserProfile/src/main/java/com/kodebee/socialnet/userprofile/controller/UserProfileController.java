package com.kodebee.socialnet.userprofile.controller;

import com.kodebee.socialnet.userprofile.model.User;
import com.kodebee.socialnet.userprofile.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserProfileController {

    private static Logger logger = LoggerFactory.getLogger(UserProfileController.class);
    @Autowired
    UserProfileService userProfileService;
    @RequestMapping(value = "/userprofiles/{uid}", method = RequestMethod.GET)
    public User getUserProfileByUid(@RequestParam(name = "uid") long uid){
        logger.info("Entering getUserProfile {}", uid);
        return userProfileService.getUserProfile(uid);
    }

    @RequestMapping(value = "/userprofiles/name/{name}", method = RequestMethod.GET)
    public List<User> getUserProfilesByName(@RequestParam(name = "name") String name){
        logger.info("Entering getUserProfilesByName {}", name);
        return userProfileService.getUserProfilesByName(name);
    }

    @RequestMapping(value = "/userprofiles", method = RequestMethod.POST)
    public void createUserProfile(@RequestBody User user){
        logger.info("Entering saveUserProfile {}", user.getName());
        userProfileService.createUserProfile(user);
    }

    @RequestMapping(value = "/userprofiles", method = RequestMethod.PUT)
    public void updateUserProfile(@RequestBody User user){
        logger.info("Entering updateUserProdile {}", user.getName());
        userProfileService.updateUserProfile(user);
    }

    @RequestMapping(value = "/userprofiles", method = RequestMethod.DELETE)
    public void deleteUserProfile(@RequestBody User user){
        logger.info("Entering deleteUserProfile {}", user.getName());
        userProfileService.deleteUserProfile(user);
    }

    @RequestMapping(value = "/userprofiles/{uid}/friends/{fuid}", method = RequestMethod.PUT)
    public void addFriend(@RequestParam(name = "uid") long uid, @RequestParam(name = "fuid") long fuid){
        logger.info("Entering addFriend {} {}", uid, fuid);
        userProfileService.addFriend(uid, fuid);
    }


}
