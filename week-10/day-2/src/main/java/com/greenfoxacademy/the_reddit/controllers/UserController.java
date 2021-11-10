package com.greenfoxacademy.the_reddit.controllers;

import com.greenfoxacademy.the_reddit.models.Post;
import com.greenfoxacademy.the_reddit.models.User;
import com.greenfoxacademy.the_reddit.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  UserService userService;

  @GetMapping("")
  public String login() {
    return "login";
  }

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "/registration")
  public String registerForm() {
    return "register";
  }

  @PostMapping(value = "/registration")
  public String register(@RequestParam String name,
                         @RequestParam String password,
                         @RequestParam String passwordVerif,
                         Model model) {
    if (password.equals(passwordVerif)) {
      userService.save(new User(name, password));
      return "redirect:/login";
    } else {
      boolean status = true;
      model.addAttribute("registrationFailed", status);
      return "register";
    }
  }

  @GetMapping(value = "/login")
  public String renderLogin(@RequestParam(required = false) boolean incorrectLogin) {
    return "login";
  }

  @PostMapping(value = "/login")
  public String login(@RequestParam String userName, @RequestParam String password, Model model) {
    if (userService.userIsValid(userName, password)) {
      userService.logUser(userName);
      return String.format("redirect:/page/%s/1", userName);
    } else {
      model.addAttribute("incorrectLogin", true);
      return "/login";
    }
  }

  @PostMapping("/submit/{userName}")
  public String savePost(@PathVariable String userName, @RequestParam String title, @RequestParam String url) {
    userService.addPost(userName, new Post(title, url, userService.findByName(userName)));
    return String.format("redirect:/page/%s/1", userName);
  }
}
