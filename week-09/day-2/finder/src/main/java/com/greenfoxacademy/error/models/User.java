package com.greenfoxacademy.error.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by aze on 25/10/17.
 */
@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
