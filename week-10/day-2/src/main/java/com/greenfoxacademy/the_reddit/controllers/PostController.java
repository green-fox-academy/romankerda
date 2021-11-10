package com.greenfoxacademy.the_reddit.controllers;

import com.greenfoxacademy.the_reddit.models.Vote;
import com.greenfoxacademy.the_reddit.repositories.VoteRepository;
import com.greenfoxacademy.the_reddit.services.PostService;
import com.greenfoxacademy.the_reddit.services.UserService;
import com.greenfoxacademy.the_reddit.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {

  PostService postService;
  UserService userService;
  VoteService voteService;

  @Autowired
  public PostController(PostService postService, UserService userService, VoteService voteService) {
    this.postService = postService;
    this.userService = userService;
    this.voteService = voteService;
  }

  @GetMapping("/{userName}")
  public String start(@PathVariable String userName, Model model) {
    if (userService.isUserLogged(userName)) {
      model.addAttribute("list", postService.findAll());
      return "index";
    }
    return "login";
  }

  @GetMapping("/submit/{userName}")
  public String submitPage(@PathVariable(required = true) String userName) {
    if (userService.isUserLogged(userName)) {
      return "submit";
    }
    return "login";
  }

  @GetMapping("/vote/{userName}/{id}/{type}/{page}")
  public String vote(@PathVariable String userName, @PathVariable Long id, @PathVariable String type, @PathVariable String page) {

    if (userService.userCanVote(userName, id, type)) {
      Optional<Vote> lastVote = voteService.findByUser_idAndPost_id(userService.findByName(userName).getId(), id);
      if(lastVote.isPresent()) {
        voteService.delete(lastVote.get());
        postService.vote(id, type);
      } else {
        postService.vote(id, type);
        voteService.save(new Vote(userService.findByName(userName), postService.findById(id), type));
      }
    }
    return String.format("redirect:/page/%s/%s", userName, page);
  }

  @GetMapping("/page/{userName}/{page}")
  public String page(@PathVariable String userName, @PathVariable String page, Model model) {
    if (userService.isUserLogged(userName)) {
      model.addAttribute("list", postService.getPage(page));
      model.addAttribute("page", page);
      return "index";
    }
    return "login";
  }
}


