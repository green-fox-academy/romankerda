package com.greenfoxacademy.frontend.services;

import org.springframework.stereotype.Service;

@Service
public class DoUntilService {


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
