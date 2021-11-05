package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;

@Getter
public enum Trick {
  HTML ("write HTML"),
  JAVA ("Java"),
  PYTHON ("Python"),
  CSS ("style CSS"),
  JS ("Java Stript"),
  CSharp ("C-sharp");

  private String name;

  private Trick(String name) {
    this.name = name;
  }
}
