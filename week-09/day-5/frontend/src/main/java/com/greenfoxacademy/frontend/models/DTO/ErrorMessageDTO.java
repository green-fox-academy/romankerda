package com.greenfoxacademy.frontend.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ErrorMessageDTO {

  private String error;

  public ErrorMessageDTO(String error) {
    this.error = error;
  }
}
