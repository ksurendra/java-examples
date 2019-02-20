package com.jaqstack.service;

import com.jaqstack.helpers.AuthenticationException;
import com.jaqstack.models.User;
import java.util.List;
import java.util.ArrayList;

import com.jaqstack.models.UserCredentials;
import com.jaqstack.service.DataService;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 * Service that provides operations for Users
 *
 * @author Suren Konathala
 */
@ApplicationScoped
public class UserService implements Serializable {

    private User user;
    private String message;

    @Inject
    DataService dataService;

    @PostConstruct
    public void init() {
        user = new User();
        message = "";
    }

    public User findUser(UserCredentials userCredentials) {
        user = dataService.findUsernamePassword(userCredentials);
        return user;
    }

    public String addUser(User user) {
        message = dataService.addUser(user);
        return message;
    }

    public User validateCredentials(UserCredentials userCredentials) {
        user = findUser(userCredentials);

        if (user == null) {
            // User cannot be found with the given username/email
            throw new AuthenticationException("Bad credentials.");
        }

        /*if (!user.isActive()) {
            // User is not active
            throw new Exception("The user is inactive.");
        }

        if (!passwordEncoder.checkPassword(password, user.getPassword())) {
           // Invalid password
            throw new AuthenticationException("Bad credentials.");
        }*/

        return user;
    }
}
