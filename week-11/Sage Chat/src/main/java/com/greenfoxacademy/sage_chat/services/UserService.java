package com.greenfoxacademy.sage_chat.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.sage_chat.dtos.UserRegisterDto;
import com.greenfoxacademy.sage_chat.models.User;
import com.greenfoxacademy.sage_chat.repositories.UserRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface UserService {

  User registerUser(String url, String login, String password) throws JsonProcessingException;
  User loginUser(String url, String login, String password) throws JsonProcessingException;
  void logoutUser(String username);
}
