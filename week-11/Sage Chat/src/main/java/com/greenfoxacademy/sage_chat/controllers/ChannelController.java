package com.greenfoxacademy.sage_chat.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greenfoxacademy.sage_chat.repositories.UserRepository;
import com.greenfoxacademy.sage_chat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/channel")
public class ChannelController {

  private UserRepository userRepository;
  private ChannelService channelService;
  private final String urlGetMessages = "https://rafale-p2p-chat.herokuapp.com/api/channel/get-messages";

  @Autowired
  public ChannelController(UserRepository userRepository, ChannelService channelService) {
    this.userRepository = userRepository;
    this.channelService = channelService;
  }

  @GetMapping("/get-messages/{username}")
  public String getMessages(@PathVariable String username, Model model) throws JsonProcessingException {

    model.addAttribute("messages", channelService.readMessages(urlGetMessages, userRepository.findByUsername(username).getApiKey(), 80));
    model.addAttribute("username", username);

    return "index";
  }
}
