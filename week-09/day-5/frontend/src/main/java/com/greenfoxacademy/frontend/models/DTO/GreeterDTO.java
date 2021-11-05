package com.greenfoxacademy.frontend.models.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class GreeterDTO {

  private String welcome_message;

  public void setWelcome_message(String welcome_message) {
    this.welcome_message = welcome_message;
  }

  public String getWelcome_message() {
    return welcome_message;
  }


}