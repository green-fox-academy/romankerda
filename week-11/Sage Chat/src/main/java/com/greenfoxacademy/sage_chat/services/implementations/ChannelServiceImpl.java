package com.greenfoxacademy.sage_chat.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.models.Channel;
import com.greenfoxacademy.sage_chat.models.Message;
import com.greenfoxacademy.sage_chat.models.MessagesWrapper;
import com.greenfoxacademy.sage_chat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

  private ObjectMapper objectMapper;
  private RestTemplate getRestTemplate;

  @Autowired
  public ChannelServiceImpl(ObjectMapper objectMapper, RestTemplate getRestTemplate) {
    this.objectMapper = objectMapper;
    this.getRestTemplate = getRestTemplate;
  }

  @Override
  public List<Message> readMessages(String url, String apiKey, int nrOfMessages) throws JsonProcessingException {
    Channel channel = new Channel();
    channel.setCount(nrOfMessages);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("apiKey", apiKey);
    HttpEntity<String> request = new HttpEntity(objectMapper.writeValueAsString(channel), headers);
    MessagesWrapper messagesWrapper = objectMapper.readValue(getRestTemplate.postForObject(url, request, String.class), MessagesWrapper.class);

    return messagesWrapper.getMessages();
  }
}
