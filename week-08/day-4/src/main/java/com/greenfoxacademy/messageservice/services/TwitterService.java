package com.greenfoxacademy.messageservice.services;

public class TwitterService implements MessageService{

  @Override
  public void processMessage(String text, String address) {
    System.out.printf("Tweet sent to: %s, with message = %s", address, text);
  }
}
