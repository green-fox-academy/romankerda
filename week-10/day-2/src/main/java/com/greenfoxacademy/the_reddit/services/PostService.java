package com.greenfoxacademy.the_reddit.services;

import com.greenfoxacademy.the_reddit.models.Post;
import com.greenfoxacademy.the_reddit.models.Vote;
import com.greenfoxacademy.the_reddit.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

  PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public void save(Post post) {
    postRepository.save(post);
  }

  public List<Post> findAll() {
    return postRepository.findAll().stream()
            .sorted(Comparator.comparingLong(Post::getPoints)
            .reversed())
            .limit(10)
            .collect(Collectors.toList());
  }

  public void vote(Long id, String type) {
    Post post = postRepository.getById(id);

    switch (type) {
      case "up":
        post.setPoints(post.getPoints() + 1);
        break;
      case "down":
        post.setPoints(post.getPoints() - 1);
        break;
    }
    postRepository.save(post);

  }

  public String getUrl(Long id) {
    return postRepository.getById(id).getUrl();
  }

  public List<Post> getPage(String page) {
    switch (page) {
      case "previous":
        return new ArrayList<>();
      case "next":
        return new ArrayList<>();
      default:
        if (page.matches("[0-9]")) {
          int offset = Integer.parseInt(page) * 10 - 10;
          return postRepository.getPage(offset);
        }
    }
    return new ArrayList<>();
  }

  public Post findById(Long id) {
    return postRepository.findById(id).get();
  }

  public void addVote(Long id, Vote vote) {
    postRepository.findById(id).get().addVote(vote);
  }
}

