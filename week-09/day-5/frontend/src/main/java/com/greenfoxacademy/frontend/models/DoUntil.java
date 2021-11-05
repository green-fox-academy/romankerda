package com.greenfoxacademy.frontend.models;

public class DoUntil {

  private int result;

  public DoUntil(String operation, int input) {
    if (operation.equals("sum")) {
      this.result = sum(input);
    } else {
      this.result = factorial(input);
    }
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public int sum(int number) {
      int sum = 0;
      for (int i = 0; i <= number ; i++) {
       sum += i;
      }
      return sum;
    }

    public int factorial(int number) {
      if (number == 1) {
        return 1;
      } return number * factorial(number -1);
    }
}
