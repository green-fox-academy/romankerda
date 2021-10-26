package com.greenfoxacademy.dependencies.coloringaround.services;

import com.greenfoxacademy.dependencies.coloringaround.services.MyColor;
import com.greenfoxacademy.dependencies.hellobeanworldapp.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedColor implements MyColor {

  private Printer printer;

  @Autowired
  public RedColor(Printer printer) {
    this.printer = printer;
  }

  public void printColor() {
    printer.log("It is red in color...");
  }

}
