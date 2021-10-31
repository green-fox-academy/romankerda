package com.greenfoxacademy.messageservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProceeder {

  @Autowired
  MessageService messageService;

  public void processMessage(String text, String address) {
    messageService.processMessage(text, address);
  }
}
