package com.greenfoxacademy.messageservice.configuration;

import com.greenfoxacademy.messageservice.services.EmailService;
import com.greenfoxacademy.messageservice.services.MessageService;
import com.greenfoxacademy.messageservice.services.MessageProceeder;
import com.greenfoxacademy.messageservice.services.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MessageConfiguration {

  @Bean
  public MessageService email() {
    return new EmailService();
  }

  @Bean
  @Primary
  public MessageService twitter() {
    return new TwitterService();
  }

  @Bean
  public MessageProceeder proceedM() {
    return new MessageProceeder();
  }




}
