package com.greenfoxacademy.sage_chat.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.dtos.UserRegisterDto;
import com.greenfoxacademy.sage_chat.models.User;
import com.greenfoxacademy.sage_chat.repositories.UserRepository;
import com.greenfoxacademy.sage_chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class DatabaseUserServiceImpl implements UserService {

  private ObjectMapper objectMapper;
  private RestTemplate getRestTemplate;
  private UserRepository userRepository;

  @Autowired
  public DatabaseUserServiceImpl(ObjectMapper objectMapper, RestTemplate getRestTemplate,
                                 UserRepository userRepository) {
    this.objectMapper = objectMapper;
    this.getRestTemplate = getRestTemplate;
    this.userRepository = userRepository;
  }

  @Override
  public User registerUser(String url, String login, String password) throws JsonProcessingException {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> request = new HttpEntity(objectMapper.writeValueAsString(new UserRegisterDto(login, password)), headers);

    User user = objectMapper.readValue(getRestTemplate.postForObject(url, request, String.class), User.class);
    user.setLogin(login);
    user.setPassword(password);
    return userRepository.save(user);
  }

  @Override
  public User loginUser(String url, String login, String password) throws JsonProcessingException {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> request = new HttpEntity(objectMapper.writeValueAsString(new UserRegisterDto(login, password)), headers);

    User userApiKey = objectMapper.readValue(getRestTemplate.postForObject(url, request, String.class), User.class);
    User currentUser = userRepository.findByLogin(login);
    currentUser.setApiKey(userApiKey.getApiKey());
    return userRepository.save(currentUser);
  }

  @Override
  public void logoutUser(String username) {
    User currentUser = userRepository.findByUsername(username);
    currentUser.setApiKey("");
    userRepository.save(currentUser);
  }
}
