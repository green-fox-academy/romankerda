package com.greenfoxacademy.animals;

import Flyable.Flyable;

public class Bird extends Animal implements Flyable {

  public Bird() {
    super();
  }

  public Bird(String name) {
    super(name);
  }

  public Bird(String name, int age) {
    super(name, age);
  }

  @Override
  public void land() {
  }

  @Override
  public void fly() {
  }

  @Override
  public void takeOff() {
  }
}