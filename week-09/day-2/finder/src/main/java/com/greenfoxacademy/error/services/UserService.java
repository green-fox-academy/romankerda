package com.greenfoxacademy.error.services;

import com.greenfoxacademy.error.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aze on 25/10/17.
 */
@Service
public class UserService {

    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public List<User> getAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

}
