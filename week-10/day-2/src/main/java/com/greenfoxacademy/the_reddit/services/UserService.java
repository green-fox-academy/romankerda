package com.greenfoxacademy.the_reddit.services;

import com.greenfoxacademy.the_reddit.models.Post;
import com.greenfoxacademy.the_reddit.models.User;
import com.greenfoxacademy.the_reddit.models.Vote;
import com.greenfoxacademy.the_reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void save(User user) {
    userRepository.save(user);
  }

  public User findByName(String name) {
    return userRepository.findByName(name);
  }

  public boolean userIsValid(String name, String password) {
    if (userRepository.findByName(name) != null && userRepository.findByName(name).getPassword().equals(password)) {
      return true;
    }
    return false;
  }

  public void addPost(String userName, Post post) {
    User currentUser = userRepository.findByName(userName);
    currentUser.addPost(post);
    userRepository.save(currentUser);
  }

  public void logUser(String userName) {
    for (User u : userRepository.findAll()) {
      u.logOut();
      userRepository.save(u);
    }
    User currentUser = userRepository.findByName(userName);
    currentUser.logIn();
    userRepository.save(currentUser);
  }

  public boolean isUserLogged(String userName) {
    User currentUser = userRepository.findByName(userName);
    if (currentUser.isLogged()) {
      return true;
    }
    return false;
  }

  public void addVote(String userName, Vote vote) {
    userRepository.findByName(userName).addVote(vote);
  }

  public boolean userCanVote(String userName, Long id, String type) {
    if (userRepository.findVoteType(userName, id, type) != null) {
      return false;
    }
    return true;
  }


}
