package com.greenfoxacademy.the_reddit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private User user;
  @ManyToOne
  private Post post;
  private String type;


public Vote(User user, Post post, String type) {
  this.user = user;
  this.post = post;
  this.type = type;
}


}
