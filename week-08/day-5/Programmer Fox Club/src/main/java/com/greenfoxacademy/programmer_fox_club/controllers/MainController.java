package com.greenfoxacademy.programmer_fox_club.controllers;

import com.greenfoxacademy.programmer_fox_club.models.Fox;
import com.greenfoxacademy.programmer_fox_club.models.User;
import com.greenfoxacademy.programmer_fox_club.repositories.FoxRepository;
import com.greenfoxacademy.programmer_fox_club.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class MainController {

  UserRepository userRepository;
  FoxRepository foxRepository;

  @Autowired
  public MainController(UserRepository userRepository, FoxRepository foxRepository) {
    this.userRepository = userRepository;
    this.foxRepository = foxRepository;
  }



//  @GetMapping(value = "")

  @GetMapping(value = "/registration")
  public String registerForm() {
    return "register";
  }

  @GetMapping(value = "/login")
  public String loginMain(@RequestParam (required = false) boolean incorrectLogin) {
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
//      foxRepository.save(fox);
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
    user.getFox().setName(name);
    userRepository.save(user);
    return String.format("redirect:/%s", userName);
  }


  @GetMapping(value = "/{userName}")
  public String startPage(@PathVariable String userName, Model model) {
    model.addAttribute("fox", userRepository.findByName(userName).getFox());
    model.addAttribute("user", userRepository.findByName(userName));
    return "index";
  }

//
//  @PostMapping(value = "/login")
//  public String loginName(@RequestParam String name) {
//    foxService.addFox(name);
//    return String.format("redirect:/?name=%s", name);
//  }
//
//  @GetMapping(value = "/nutritionStore")
//  public String nutritionStore(@RequestParam String name, Model model) {
//    model.addAttribute("foodList", Food.values());
//    model.addAttribute("drinkList", Drink.values());
//    model.addAttribute("fox", foxService.getFox(name));
//    return "nutritionStore";
//  }
//
//  @GetMapping(value = "/trickCenter")
//  public String trickCenter(@RequestParam String name, Model model) {
//    model.addAttribute("trickList", foxService.getTricksToLearn(name));
//    model.addAttribute("fox", foxService.getFox(name));
//    return "trickCenter";
//  }
//
//  @GetMapping(value = "/actionHistory")
//  public String actionHistory(@RequestParam String name, Model model) {
//    model.addAttribute("fox", foxService.getFox(name));
//    return "actionHistory";
//  }
}
