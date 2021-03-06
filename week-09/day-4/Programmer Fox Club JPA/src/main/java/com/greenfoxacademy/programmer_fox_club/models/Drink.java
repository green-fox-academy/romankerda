package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
public enum Drink {
  WATER ("water"),
  BEER ("beer"),
  LEMONADE ("lemonade"),
  GIN ("gin"),
  TONIC ("tonic"),
  RUM ("rum");

  private final String name;

  Drink (String name) {
    this.name = name;
  }
}
