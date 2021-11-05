package com.greenfoxacademy.frontend.models.DTO;


public class DoublingErrorDTO {

  private String error = "Please provide an input!";

  public DoublingErrorDTO() {
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
