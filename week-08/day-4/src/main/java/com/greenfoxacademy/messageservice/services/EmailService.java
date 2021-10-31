package com.greenfoxacademy.messageservice.services;

import org.springframework.stereotype.Service;


public class EmailService implements MessageService{
  @Override
  public void processMessage(String text, String address) {
    System.out.printf("Email sent to: %s, with message = %s", address, text);

  }
}
