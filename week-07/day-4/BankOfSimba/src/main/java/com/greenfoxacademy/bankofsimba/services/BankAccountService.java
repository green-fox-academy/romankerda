package com.greenfoxacademy.bankofsimba.services;

import com.greenfoxacademy.bankofsimba.models.AnimalType;
import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
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

  public List<BankAccount> getAccounts() {
    return accountList;
  }

  public void raise(int idx) {
    accountList.get(idx).raiseBalance();
  }

  public void addAccount(BankAccount bankAccount) {
    accountList.add(bankAccount);
  }
}

