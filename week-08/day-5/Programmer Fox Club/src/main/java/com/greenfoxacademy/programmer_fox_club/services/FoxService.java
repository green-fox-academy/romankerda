package com.greenfoxacademy.programmer_fox_club.services;


import com.greenfoxacademy.programmer_fox_club.models.Drink;
import com.greenfoxacademy.programmer_fox_club.models.Food;
import com.greenfoxacademy.programmer_fox_club.models.Fox;
import com.greenfoxacademy.programmer_fox_club.models.Trick;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoxService {

  private List<Fox> foxList;


  public FoxService() {
    foxList = new ArrayList<>();
  }

  public boolean add(String name) {
    if (!isFoxInList(name)) {
      foxList.add(new Fox(name));
      return true;
    }
    return false;
  }

  public Fox findActualFox(String name) {
    if (isFoxInList(name)) {
      List<Fox> foxes = foxList.stream()
              .filter(f -> f.getName().equals(name))
              .collect(Collectors.toList());
      return foxes.get(0);
    }
    add(name);
    return foxList.get(foxList.size() - 1);
  }

  public boolean isFoxInList(String name) {
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
    Fox actualFox = findActualFox(name);
    actualFox.getTricks().add(Trick.valueOf(trick));
    actualFox.getActionHistory().add(String.format("%s : Learnt to : %s.", getCurrentDate(), Trick.valueOf(trick).getName()));
  }

  public List<Trick> getTricksToLearn(String name) {
    Fox actualFox = findActualFox(name);
    List<Trick> tricksToLearn = new ArrayList<>();
    tricksToLearn.addAll(Arrays.asList(Trick.values()));
    for (Trick trick : actualFox.getTricks()) {
      tricksToLearn.remove(trick);
    }
    return tricksToLearn;
  }

  public String getCurrentDate() {
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy. MMMM dd. HH:mm:ss");
    return date.format(dateFormat);
  }

  public void changeDrink(String name, Drink drink) {
    Fox actualFox = findActualFox(name);
    if (actualFox.getDrink() != drink) {
      actualFox.getActionHistory().add(String.format("%s : Drink changed from : %s to : %s.",
              getCurrentDate(), actualFox.getDrink().getName(), drink.getName()));
      actualFox.setDrink(drink);
    }
  }

  public void changeFood(String name, Food food) {
    Fox actualFox = findActualFox(name);
    if (actualFox.getFood() != food) {
      actualFox.getActionHistory().add(String.format("%s : Food changed from : %s to : %s.",
              getCurrentDate(), actualFox.getFood().getName(), food.getName()));
      actualFox.setFood(food);
    }
  }

  public List<String> getShortHistory(String name) {
    Fox actualFox = findActualFox(name);
    int start = (actualFox.getActionHistory().size() - 5 < 0 ? 0 :actualFox.getActionHistory().size() - 5);
    if (!actualFox.getActionHistory().isEmpty()) {
      return actualFox.getActionHistory().subList(start, actualFox.getActionHistory().size());
    }
    return new ArrayList<String>();
  }

}
