package com.greenfoxacademy.frontend.models;

import java.util.Arrays;

public class ArrayHandler {

  private String what;
  private int[] numbers;
  private int result;
  private int[] resultArr;

  public ArrayHandler() {
  }

  public void calculate() {
    resultArr = new int[numbers.length];
    if (this.what.equals("multiply")) {
      result = 1;
    } else {
      result = 0;
    }

    for (int i = 0; i < numbers.length; i++) {
      if (this.what.equals("double")) {
        resultArr[i] = numbers[i] * 2;
      }
      if (this.what.equals("sum")) {
        result += numbers[i];
      }
      if (this.what.equals("multiply"))
        result *= numbers[i];
    }
  }



  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  public int[] getNumbers() {
    return numbers;
  }

  public void setNumbers(int[] numbers) {
    this.numbers = numbers;
  }

  public int getResult() {
    return result;
  }

  public void setResult(int result) {
    this.result = result;
  }

  public int[] getResultArr() {
    return resultArr;
  }

  public void setResultArr(int[] resultArr) {
    this.resultArr = resultArr;
  }
}
