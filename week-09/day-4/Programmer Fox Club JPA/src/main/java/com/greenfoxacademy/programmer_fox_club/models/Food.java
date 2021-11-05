package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;

import javax.persistence.Entity;


public enum Food {
  PIZZA ("pizza"),
  BREAD ("bread"),
  SPAGHETTI ("spaghetti"),
  PASTA ("pasta"),
  SAUSAGES ("sausages"),
  POTATOS ("potatos"),
  TOMATOS ("tomatos"),
  SALADE ("salade");

  private final String name;

  private Food (String name) {
    this.name = name;
  }
}
