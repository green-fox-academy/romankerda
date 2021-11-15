package com.greenfoxacademy.groot.dtos;

import com.greenfoxacademy.groot.models.Message;

public class MessageDto {

  private final String received;
  private final String translated = "I am Groot!";


  public MessageDto(String received) {
    this.received = received;
  }

  public MessageDto(Message message) {
    this.received = message.getMessage();
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
}
