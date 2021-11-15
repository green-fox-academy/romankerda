package com.greenfoxacademy.groot.models;

public class Message {

  private String message;
  private String received;
  private String translated;

  public Message() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getReceived() {
    return received;
  }

  public String getTranslated() {
    return translated;
  }
}
