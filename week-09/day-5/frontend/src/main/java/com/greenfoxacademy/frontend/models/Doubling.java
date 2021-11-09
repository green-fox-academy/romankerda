package com.greenfoxacademy.frontend.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Doubling {

  private int received;
  private int result;


  public Doubling() {
  }

  public Integer getReceived() {
    return received;
  }

  public Integer getResult() {
    return result;
  }

  public void setReceived(int received) {
    this.received = received;
  }

  public void setResult(int result) {
    this.result = result;
  }

  //  public String getError() {
//    return error;
//  }
}

