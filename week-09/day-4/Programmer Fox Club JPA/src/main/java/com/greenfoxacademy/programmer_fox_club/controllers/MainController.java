package com.greenfoxacademy.programmer_fox_club.controllers;

import com.greenfoxacademy.programmer_fox_club.models.*;
import com.greenfoxacademy.programmer_fox_club.repositories.FoxRepository;
import com.greenfoxacademy.programmer_fox_club.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.swing.SwingUtilities2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@Controller
public class MainController {

  UserRepository userRepository;
  FoxRepository foxRepository;

  @Autowired
  public MainController(UserRepository userRepository, FoxRepository foxRepository) {
    this.userRepository = userRepository;
    this.foxRepository = foxRepository;
  }

  @GetMapping(value = "/registration")
  public String registerForm() {
    return "register";
  }

  @GetMapping(value = "/login")
  public String loginMain(@RequestParam(required = false) boolean incorrectLogin) {
    return "login";
  }

  @PostMapping(value = "/login")
  public String loginMain(@RequestParam String name, @RequestParam String password, Model model) {
    User user = userRepository.findByName(name);
    if (user != null && user.getPassword().equals(password)) {
      return String.format("redirect:/%s", user.getName());
    } else {
      model.addAttribute("incorrectLogin", true);
      return "/login";
    }
  }

  @PostMapping(value = "/registration")
  public String register(@RequestParam String name,
                         @RequestParam String password1,
                         @RequestParam String password2,
                         Model model) {
    if (password1.equals(password2)) {
      User user = new User();
      user.setName(name);
      user.setPassword(password1);
      Fox fox = new Fox();
      user.setFox(fox);
      fox.setUser(user);
      userRepository.save(user);
      return String.format("redirect:/login/%s", user.getName());
    } else {
      boolean failed = true;
      model.addAttribute("registrationFailed", failed);
      return "register";
    }
  }

  @GetMapping(value = "/login/{userName}")
  public String loginForm(@PathVariable String userName, Model model) {
    model.addAttribute("userName", userName);
    return "loginFox";
  }

  @PostMapping(value = "/login/{userName}")
  public String login(@PathVariable String userName, @RequestParam String name, Model model) {
    User user = userRepository.findByName(userName);
    foxRepository.findFoxByUserName(userName).setName(name);
    userRepository.save(user);
    return String.format("redirect:/%s", userName);
  }

  @GetMapping(value = "/{userName}")
  public String startPage(@PathVariable String userName, Model model) {

    Fox fox = userRepository.findByName(userName).getFox();
    List<Action> full = fox.getActions();
    List<Action> historyShort = full.subList(full.size()-5, full.size());

    model.addAttribute("fox", userRepository.findByName(userName).getFox());
    model.addAttribute("user", userRepository.findByName(userName));
    model.addAttribute("historyShort", historyShort);

    return "index";
  }
}
