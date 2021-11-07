package com.greenfoxacademy.programmer_fox_club.controllers;

import com.greenfoxacademy.programmer_fox_club.models.*;
import com.greenfoxacademy.programmer_fox_club.repositories.FoxRepository;
import com.greenfoxacademy.programmer_fox_club.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class FoxController {

  private UserRepository userRepository;
  private FoxRepository foxRepository;

  @Autowired
  public FoxController(UserRepository userRepository, FoxRepository foxRepository) {
    this.foxRepository = foxRepository;
    this.userRepository = userRepository;
  }

  @GetMapping(value = "/nutritionStore/{userName}")
  public String nutritionStore(@PathVariable String userName, Model model) {
    model.addAttribute("foodList", Food.values());
    model.addAttribute("drinkList", Drink.values());
    model.addAttribute("userName", userName);
    model.addAttribute("fox", foxRepository.findFoxByUserName(userName));
    return "nutritionStore";
  }

  @PostMapping(value = "/nutritionStore/{userName}")
  public String changeNutrition(@PathVariable String userName,
                                @RequestParam String food,
                                @RequestParam String drink,
                                Model model) {
    model.addAttribute("userName", userName);
    User user = userRepository.findByName(userName);
    Fox fox = foxRepository.findFoxByUserName(userName);
    if (!fox.getDrink().getName().equalsIgnoreCase(drink)) {
      fox.addAction(new Action(fox, String.format("Drink changed from: %s to: %s.", fox.getDrink().getName(), drink.toLowerCase())));
    }
    if (!fox.getFood().getName().equalsIgnoreCase(food)) {
      fox.addAction(new Action(fox, String.format("Food changed from: %s to: %s.", fox.getFood().getName(), food.toLowerCase())));
    }
    fox.setDrink(Drink.valueOf(drink));
    fox.setFood(Food.valueOf(food));
    userRepository.save(user);
    return String.format("redirect:/%s", userName);
  }

  @GetMapping(value = "/trickCenter/{userName}")
  public String trickCenter(@PathVariable String userName, Model model) {
    Fox fox = foxRepository.findFoxByUserName(userName);
    List<TrickEnum> learntTricks = fox.getTricks().stream()
            .map(t -> t.getTrickEnum())
            .collect(Collectors.toList());
    List<TrickEnum> allTricks = Arrays.asList(TrickEnum.values());
    List<TrickEnum> availableTricks = allTricks.stream()
            .filter(t -> !learntTricks.contains(t))
            .collect(Collectors.toList());

    model.addAttribute("trickList", availableTricks);
    model.addAttribute("userName", userName);
    return "trickCenter";
  }

  @PostMapping(value = "/trickCenter/{userName}")
  public String addTrick(@PathVariable String userName,
                         @RequestParam String trick,
                         Model model) {

    model.addAttribute("userName", userName);
    User user = userRepository.findByName(userName);
    Fox fox = foxRepository.findFoxByUserName(userName);
    fox.addAction(new Action(fox, String.format("Learnt to: %s", trick.toLowerCase())));
    Trick trickNew = new Trick();
    trickNew.setTrickEnum(TrickEnum.valueOf(trick));
    trickNew.setFox(fox);
    fox.addTrick(trickNew);
    userRepository.save(user);
    return String.format("redirect:/%s", userName);
  }

  @GetMapping(value = "/actionHistory/{userName}")
  public String actionHistory(@PathVariable String userName, Model model) {
    model.addAttribute("fox", foxRepository.findFoxByUserName(userName));
    return "actionHistory";
  }
}

