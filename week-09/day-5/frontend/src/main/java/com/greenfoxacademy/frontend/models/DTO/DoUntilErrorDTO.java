package com.greenfoxacademy.frontend.models.DTO;

public class DoUntilErrorDTO {

  private String error;

  public DoUntilErrorDTO() {
    this.error = "Please provide a number!";
  }

  public String getError() {
    return error;
  }

}
