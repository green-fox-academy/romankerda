package com.greenfoxacademy.animals;

public abstract class Animal {

  public enum Gender {MALE, FEMALE}

  public String name;
  public int age;
  public Gender gender;


  public Animal() {}

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String breed() {
    return "by laying eggs";
  }

  public int getAge() {
    return age;
  }

  public String sleep() {
    return "Shhhh hmmmm shhhh hmmm";
  }
}
