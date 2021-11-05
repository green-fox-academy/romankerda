package com.greenfoxacademy.frontend.models;

public class Number {

  private Integer until;

  public Number(int until) {
    this.until = until;
  }

  public Number() {
  }

  public int getUntil() {
    return until;
  }

  public void setUntil(Integer until) {
    this.until = until;
  }
}
