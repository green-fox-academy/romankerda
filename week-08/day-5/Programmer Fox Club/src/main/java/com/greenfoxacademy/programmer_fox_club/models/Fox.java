package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

}
