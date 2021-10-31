package com.greenfoxacademy.bankofsimba.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
  private String name;
  private double balance;
  private AnimalType animalType;
  private Boolean isKing;


  public void raiseBalance() {
    //if king's account then raise by 100, if not king's account raise by 10:
    balance = this.isKing ? balance + 100 : balance + 10;
  }
}
