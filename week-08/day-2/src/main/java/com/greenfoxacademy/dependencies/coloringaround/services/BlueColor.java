package com.greenfoxacademy.dependencies.coloringaround.services;

import com.greenfoxacademy.dependencies.coloringaround.services.MyColor;
import com.greenfoxacademy.dependencies.hellobeanworldapp.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class BlueColor implements MyColor {

  Printer printer;

  @Autowired
  public BlueColor(Printer printer) {
    this.printer = printer;
  }

  public void printColor() {
    printer.log("It is blue in color ...");
  }

}