package com.greenfoxacademy.programmer_fox_club;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProgrammerFoxClubApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ProgrammerFoxClubApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {


  }
}
