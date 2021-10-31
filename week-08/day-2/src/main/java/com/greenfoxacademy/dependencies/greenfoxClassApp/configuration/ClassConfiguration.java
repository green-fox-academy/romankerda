package com.greenfoxacademy.dependencies.greenfoxClassApp.configuration;

import com.greenfoxacademy.dependencies.greenfoxClassApp.services.StudentService;
import com.greenfoxacademy.dependencies.greenfoxClassApp.services.StudentServiceFileImpl;
import com.greenfoxacademy.dependencies.greenfoxClassApp.services.StudentServiceListImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ClassConfiguration {

  @Bean
  public StudentService createListImpl() {
   return new StudentServiceListImpl();
  }

  @Bean
  @Primary
  public StudentService createFileImpl() {
    return new StudentServiceFileImpl();
  }
}
