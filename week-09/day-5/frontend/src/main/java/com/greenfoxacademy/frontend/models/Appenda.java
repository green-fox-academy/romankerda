package com.greenfoxacademy.frontend.models;

import lombok.Getter;

@Getter
public class Appenda {

  private String appended;

  public Appenda (String input) {
    appended = input + "a";
  }

  public String getAppended() {
    return appended;
  }
}
