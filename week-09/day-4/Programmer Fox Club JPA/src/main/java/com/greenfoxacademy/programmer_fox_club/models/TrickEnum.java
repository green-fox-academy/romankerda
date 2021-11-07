package com.greenfoxacademy.programmer_fox_club.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
public enum TrickEnum {
  HTML ("write HTML"),
  JAVA ("Java"),
  PYTHON ("Python"),
  CSS ("style CSS"),
  JS ("Java Stript"),
  CSharp ("C-sharp");

  private String name;

  private TrickEnum(String name) {
    this.name = name;
  }
}
