package com.greenfoxacademy.sage_chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Author {

  private String username;
  private String userId;
  private String avatarurl;
}
