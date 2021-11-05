package com.greenfoxacademy.frontend.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Greeter {

  private String name;
  private String title;
  private String welcome_message;
  private String error;

  public Greeter(String name, String title) {
    this.name = name;
    this.title = title;
    this.welcome_message = String.format("Oh, hi there %s, my dear %s!", name, title);
  }

  public String getWelcome_message() {
    return welcome_message;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setWelcome_message(String welcome_message) {
    this.welcome_message = welcome_message;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
