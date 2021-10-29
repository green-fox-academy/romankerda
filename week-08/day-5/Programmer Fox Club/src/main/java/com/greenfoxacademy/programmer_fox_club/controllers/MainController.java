package com.greenfoxacademy.programmer_fox_club.controllers;

import com.greenfoxacademy.programmer_fox_club.models.Drink;
import com.greenfoxacademy.programmer_fox_club.models.Food;
import com.greenfoxacademy.programmer_fox_club.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

  FoxService foxService;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping(value = "/")
  public String start(@RequestParam (defaultValue = "empty") String name, Model model) {
    model.addAttribute("fox", foxService.findActualFox(name));
    model.addAttribute("name", "present");
    model.addAttribute("historyShort", foxService.getShortHistory(name));
    if (name.equals("empty")) {
      model.addAttribute("name", "notPresent");
    }
    return "index";
  }

  @GetMapping(value = "/login")
  public String login() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String loginName(@RequestParam String name) {
    foxService.add(name);
    return String.format("redirect:/?name=%s", name);
  }

  @GetMapping(value = "/nutritionStore")
  public String nutritionStore(@RequestParam String name, Model model) {
    model.addAttribute("foodList", Food.values());
    model.addAttribute("drinkList", Drink.values());
    model.addAttribute("fox", foxService.findActualFox(name));
    return "nutritionStore";
  }

  @GetMapping(value = "/trickCenter")
  public String trickCenter(@RequestParam String name, Model model) {
    model.addAttribute("trickList", foxService.getTricksToLearn(name));
    model.addAttribute("fox", foxService.findActualFox(name));
    return "trickCenter";
  }

  @GetMapping(value = "/actionHistory")
  public String actionHistory(@RequestParam String name, Model model) {
    model.addAttribute("fox", foxService.findActualFox(name));
    return "actionHistory";
  }
}
