package com.greenfoxacademy.sage_chat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {

  void postMessage(String content, String apiKey, String url) throws JsonProcessingException;
}
