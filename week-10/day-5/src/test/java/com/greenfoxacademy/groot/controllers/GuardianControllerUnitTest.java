package com.greenfoxacademy.groot.controllers;

import com.greenfoxacademy.groot.exceptions.QuerryParameterNotReceivedException;
import org.junit.jupiter.api.Assertions;
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

  @Test
  @DisplayName("When no input provided for Yondu")
  void whenNoInputProvidedForYondu() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/yondu"))
            .andExpect(status().isBadRequest())
            .andExpect(content().string(equalTo("No parameters provided")))
    ;
  }

  @Test
  @DisplayName("When zero time providede for Yondu endpoint")
  void whenZeroTimeProvidedeForYonduEndpoint() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/yondu?time=0&distance=20"))
            .andExpect(status().isForbidden())
            .andExpect(content().string(equalTo("Time can't be zero")))
    ;
  }

  @Test
  @DisplayName("Correct parameters provided for Yondu")
  void correctParametersProvidedForYondu() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/yondu?time=3&distance=10"))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("{\"distance\":10.0,\"time\":3.0,\"speed\":3.33}")))
    ;
  }






}

