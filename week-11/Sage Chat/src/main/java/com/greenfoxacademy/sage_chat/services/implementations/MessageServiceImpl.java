package com.greenfoxacademy.sage_chat.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.dtos.MessageSendDto;
import com.greenfoxacademy.sage_chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class MessageServiceImpl implements MessageService {

  private ObjectMapper objectMapper;
  private RestTemplate getRestTemplate;

  @Autowired
  public MessageServiceImpl(ObjectMapper objectMapper, RestTemplate getRestTemplate) {
    this.objectMapper = objectMapper;
    this.getRestTemplate = getRestTemplate;
  }

  @Override
  public void postMessage(String content, String apiKey, String url) throws JsonProcessingException {

    MessageSendDto messageSendDto = new MessageSendDto();
    messageSendDto.setContent(content);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("apiKey", apiKey);
    HttpEntity<String> request = new HttpEntity(objectMapper.writeValueAsString(messageSendDto), headers);

    getRestTemplate.postForObject(url, request, String.class);
  }
}
