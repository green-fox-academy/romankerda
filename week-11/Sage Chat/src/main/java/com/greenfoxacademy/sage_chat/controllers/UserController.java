package com.greenfoxacademy.sage_chat.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.dtos.UserRegisterDto;
import com.greenfoxacademy.sage_chat.models.User;
import com.greenfoxacademy.sage_chat.repositories.UserRepository;
import com.greenfoxacademy.sage_chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Controller
@RequestMapping("/api/user")
public class UserController {

  private UserService userService;
  private final String urlRegister = "https://rafale-p2p-chat.herokuapp.com/api/user/register";
  private final String urlLogin = "https://rafale-p2p-chat.herokuapp.com/api/user/login";

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String renderRegisterForm() {
    return "registrationForm";
  }

  @PostMapping(value = "/register")
  public String registerUser(@RequestParam String login, @RequestParam String password) throws IOException {
    userService.registerUser(urlRegister, login, password);
    return "loginForm";
  }

  @GetMapping("/login")
  public String renderLoginForm() {
    return "loginForm";
  }

  @PostMapping(value = "/login")
  public String loginUser(@RequestParam String login, @RequestParam String password) throws IOException {
    User currentUser = userService.loginUser(urlLogin, login, password);
    return String.format("redirect:/api/channel/get-messages/%s", currentUser.getUsername());
  }

  @GetMapping("/logout/{username}")
  public String logoutUser(@PathVariable String username) {
    userService.logoutUser(username);
    return "redirect:/api/user/login";
  }



}
