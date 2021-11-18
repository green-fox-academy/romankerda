package com.greenfoxacademy.sage_chat.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.dtos.MessageSendDto;
import com.greenfoxacademy.sage_chat.repositories.UserRepository;
import com.greenfoxacademy.sage_chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/message")
public class MessageController {

  private UserRepository userRepository;
  private MessageService messageService;
  private final String urlPostMessage = "https://rafale-p2p-chat.herokuapp.com/api/message/";

  @Autowired
  public MessageController(UserRepository userRepository, MessageService messageService) {
    this.userRepository = userRepository;
    this.messageService = messageService;
  }

  @PostMapping(value = "/{username}")
  public String postMessage(@PathVariable String username, @RequestParam String content, Model model) throws JsonProcessingException {

    messageService.postMessage(content, userRepository.findByUsername(username).getApiKey(), urlPostMessage);

    return String.format("redirect:/api/channel/get-messages/%s", username);
  }
}
