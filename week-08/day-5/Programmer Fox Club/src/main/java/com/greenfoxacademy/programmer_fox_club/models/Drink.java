package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;

@Getter
public enum Drink {
  WATER ("water"),
  BEER ("beer"),
  LEMONADE ("lemonade"),
  GIN ("gin"),
  TONIC ("tonic"),
  RUM ("rum");

  private final String name;

  private Drink (String name) {
    this.name = name;
  }
}
