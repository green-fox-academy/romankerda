package com.greenfoxacademy.frontend.models.DTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GreeterErrorDTO {

  private String error;

  public void setError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }
}