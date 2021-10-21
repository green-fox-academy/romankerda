package com.greenfoxacademy.bankofsimba.services;

import com.greenfoxacademy.bankofsimba.models.AnimalType;
import com.greenfoxacademy.bankofsimba.models.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccountService {

  private List<BankAccount> accountList;

  public BankAccountService() {
    accountList = new ArrayList(Arrays
            .asList(
                    new BankAccount("Simba", 2000, AnimalType.LION, true),
                    new BankAccount("Kiara", 5000, AnimalType.LION, false),
                    new BankAccount("Elso", 7000, AnimalType.PENGUIN, false),
                    new BankAccount("Thurston", 1000, AnimalType.ZEBRA, false),
                    new BankAccount("Bimbo", 20000, AnimalType.GIRAFFE, false)
            ));
  }

  public List<BankAccount> getAll() {
    return accountList;
  }

  public void raise(int idx) {
    //if king's account then raise by 100, if not king's account raise by 10:
    accountList.get(idx).setBalance(
            accountList.get(idx).getIsKing() ? accountList.get(idx).getBalance()+100 : accountList.get(idx).getBalance()+10
    );
  }

  public void addNew(BankAccount bankAccount) {
    accountList.add(bankAccount);
  }
}

