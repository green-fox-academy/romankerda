package com.greenfoxacademy.programmer_fox_club.controllers;

import com.greenfoxacademy.programmer_fox_club.models.Drink;
import com.greenfoxacademy.programmer_fox_club.models.Food;
import com.greenfoxacademy.programmer_fox_club.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

  private FoxService foxService;

  @Autowired
  public FoxController(FoxService foxService) {
    this.foxService = foxService;
  }
//
//  @PostMapping(value = "/nutritionStore")
//  public String changeNutrition(@RequestParam String name,
//                                @RequestParam String food,
//                                @RequestParam String drink,
//                                Model model) {
//    foxService.changeDrink(name, Drink.valueOf(drink));
//    foxService.changeFood(name, Food.valueOf(food));
//    return String.format("redirect:/?name=%s", name);
//  }
//
//  @PostMapping(value = "/trickCenter")
//  public String addTrick(@RequestParam String name,
//                         @RequestParam String trick,
//                         Model model) {
//    foxService.addTrick(name, trick);
//    return String.format("redirect:/?name=%s", name);
//  }

}
