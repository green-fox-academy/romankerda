package com.greenfoxacademy.sage_chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Message {

  private String content;
  private String created;
  private Author author;
}
