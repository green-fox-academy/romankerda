package com.greenfoxacademy.messageservice.services;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {

  void processMessage(String text, String address);

}
