package com.greenfoxacademy.the_reddit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "pid")
  private Long id;
  private String title;
  private String url;
  private int points;
  @Temporal(TemporalType.DATE)
  private Date date;
  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "uid")
  private User user;
  @OneToMany(mappedBy = "post")
  private List<Vote> votes;

  public Post(String title, String url, User user) {
    this.title = title;
    this.url = url;
    this.user = user;
    points = 0;
    date = new Date();

  }

  public void addVote(Vote vote) {
    votes.add(vote);
  }

}



