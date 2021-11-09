package com.greenfoxacademy.frontend.models.DTO;


import com.greenfoxacademy.frontend.models.Greeter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GreeterDTO {

  private String welcome_message;

  public GreeterDTO(Greeter greeter) {
    this.welcome_message = greeter.getWelcome_message();
  }

  public void setWelcome_message(String welcome_message) {
    this.welcome_message = welcome_message;
  }



}