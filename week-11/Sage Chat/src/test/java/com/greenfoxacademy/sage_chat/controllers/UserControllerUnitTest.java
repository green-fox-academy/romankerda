package com.greenfoxacademy.sage_chat.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerUnitTest {
  
  @Autowired
  MockMvc mvc;
  
@Test
@DisplayName("register with login and password")
void registerWithLoginAndPassword() throws Exception {

  mvc.perform(MockMvcRequestBuilders.post("/register")
              .param("login", "loginName")
              .param("password", "abc"))
          .andExpect(status().isOk());

}

  

}