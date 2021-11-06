package com.greenfoxacademy.frontend.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {


  private Long id;
  private String endpoint;
  private String data;

}
