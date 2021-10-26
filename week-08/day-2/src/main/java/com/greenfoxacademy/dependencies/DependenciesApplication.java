package com.greenfoxacademy.dependencies;

import com.greenfoxacademy.dependencies.coloringaround.services.MyColor;
import com.greenfoxacademy.dependencies.hellobeanworldapp.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependenciesApplication implements CommandLineRunner {

  private MyColor myColor;
  private Printer printer;

  @Autowired
  public DependenciesApplication (MyColor myColor) {
    this.myColor = myColor;
  }

  public static void main(String[] args) {
    SpringApplication.run(DependenciesApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    myColor.printColor();
  }
}
