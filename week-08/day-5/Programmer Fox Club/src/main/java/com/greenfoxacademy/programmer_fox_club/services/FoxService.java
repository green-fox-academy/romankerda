package com.greenfoxacademy.programmer_fox_club.services;


import com.greenfoxacademy.programmer_fox_club.models.Drink;
import com.greenfoxacademy.programmer_fox_club.models.Food;
import com.greenfoxacademy.programmer_fox_club.models.Fox;
import com.greenfoxacademy.programmer_fox_club.models.Trick;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoxService {

  private List<Fox> foxList;


  public FoxService() {
    foxList = new ArrayList<>();
  }

  public boolean addFox(String name) {
    if (!isOnList(name)) {
      foxList.add(new Fox(name));
      return true;
    }
    return false;
  }

  public Fox getFox(String name) {
    if (isOnList(name)) {
      List<Fox> foxes = foxList.stream()
              .filter(f -> f.getName().equals(name))
              .collect(Collectors.toList());
      return foxes.get(0);
    }
    addFox(name);
    return foxList.get(foxList.size() - 1);
  }

  public boolean isOnList(String name) {
    if (foxList.isEmpty()) {
      return false;
    } else {
      List<String> foxes = foxList.stream()
              .map(f -> f.getName())
              .collect(Collectors.toList());
      return foxes.contains(name) ? true : false;
    }
  }

  public void addTrick(String name, String trick) {
    getFox(name).addTrick(trick);
  }

  public List<Trick> getTricksToLearn(String name) {
    return getFox(name).getTricksToLearn();
  }

  public void changeDrink(String name, Drink drink) {
    getFox(name).setDrink(drink);
  }

  public void changeFood(String name, Food food) {
    getFox(name).setFood(food);
  }

  public List<String> getShortActionHistory(String name) {
    return getFox(name).getShortActionHistory();
  }
}
