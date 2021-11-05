package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Fox {

  private String name;
  private List<Trick> tricks;
  private Food food;
  private Drink drink;
  private List<String> actionHistory;


  public Fox(String name) {
    this.name = name;
    tricks = new ArrayList<>();
    food = Food.POTATOS;
    drink = Drink.BEER;
    actionHistory = new ArrayList<>();
  }

  public void addTrick(String trick) {
    tricks.add(Trick.valueOf(trick));
    actionHistory.add(String.format("%s : Learnt to : %s.", getCurrentDate(), Trick.valueOf(trick).getName()));
  }

  public String getCurrentDate() {
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy. MMMM dd. HH:mm:ss");
    return date.format(dateFormat);
  }

  public List<Trick> getTricksToLearn() {
    List<Trick> tricksToLearn = new ArrayList<>();
    tricksToLearn.addAll(Arrays.asList(Trick.values()));
    for (Trick trick : tricks) {
      tricksToLearn.remove(trick);
    }
    return tricksToLearn;
  }

  public void setDrink(Drink drink) {
    if (this.drink != drink) {
      actionHistory.add(String.format("%s : Drink changed from : %s to : %s.",
              getCurrentDate(), this.drink.getName(), drink.getName()));
      this.drink = drink;
    }
  }

  public void setFood(Food food) {
    if (this.food != food) {
      actionHistory.add(String.format("%s : Food changed from : %s to : %s.",
              getCurrentDate(), this.food.getName(), food.getName()));
      this.food = food;
    }
  }

  public List<String> getShortActionHistory() {
    int start = (actionHistory.size() - 5 < 0 ? 0 : actionHistory.size() - 5);
    if (!actionHistory.isEmpty()) {
      return actionHistory.subList(start, actionHistory.size());
    }
    return actionHistory;
  }
}
