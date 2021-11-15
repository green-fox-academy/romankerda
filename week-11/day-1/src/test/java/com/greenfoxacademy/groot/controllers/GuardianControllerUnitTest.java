package com.greenfoxacademy.groot.controllers;

import com.greenfoxacademy.groot.exceptions.QuerryParameterNotReceivedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GuardianController.class)
class GuardianControllerUnitTest {

  @Autowired
  private MockMvc mvc;


  @Test
  @DisplayName("When no input provided")
  void whenNoInputProvided() throws Exception {


    mvc.perform(MockMvcRequestBuilders.get("/groot"))
            .andExpect(status().isBadRequest())
            .andExpect(content().string(equalTo(
                    "{\"error\":\"I am Groot!\"}")))
    ;
  }

  @Test
  @DisplayName("Correct input provided")
  void correctInputProvided() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/groot?message=somemessage"))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(
                    "{\"received\":\"somemessage\",\"translated\":\"I am Groot!\"}")))
    ;

  }

}

