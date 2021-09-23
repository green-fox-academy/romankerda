package com.greenfoxacademy.animals;

public class Mammal extends Animal {

  public Mammal() {
    super();
  }

  public Mammal(String name) {
    super(name);
  }

  public Mammal(String name, int age) {
    super(name, age);
  }

  @Override
  public String breed() {
    return "pushing miniature version out";
  }
}
