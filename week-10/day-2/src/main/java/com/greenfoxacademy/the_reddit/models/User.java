package com.greenfoxacademy.the_reddit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "uid")
  private Long id;
  private String name;
  private String password;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<Post> posts;
  private boolean isLogged;
  @OneToMany(mappedBy = "user")
  private List<Vote> votes;


  public User(String name, String password) {
    this.name = name;
    this.password = password;
    posts = new ArrayList<>();
  }

  public void addPost(Post post) {
    posts.add(post);
  }

  public void logOut() {
    this.isLogged = false;
  }

  public void logIn() {
    this.isLogged = true;
  }

  public void addVote(Vote vote) {
    votes.add(vote);
  }


}
