package com.greenfoxacademy.sage_chat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.models.Channel;
import com.greenfoxacademy.sage_chat.models.Message;
import com.greenfoxacademy.sage_chat.models.MessagesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public interface ChannelService {

  List<Message> readMessages(String url, String apiKey, int nrOfMessages) throws JsonProcessingException;
}

