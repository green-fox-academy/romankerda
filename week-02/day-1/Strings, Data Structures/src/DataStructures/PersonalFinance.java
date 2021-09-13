package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonalFinance {
  public static void main(String[] args) {
    //We are going to represent our expenses in a list containing integers.
    //
    //Create a list with the following items:
    //500, 1000, 1250, 175, 800 and 120

    List<Integer> expenses = new ArrayList<>();
    Collections.addAll(expenses, 500, 1000, 1250, 175, 800, 120);

    //Create an application which prints out the answers to the following questions:
    //How much did we spend?
    //Which was our greatest expense?
    // Which was our cheapest spending?
    //What was the average amount of our spendings?

    int sum = 0;
    int max = 0;
    int min = 99999999;
    int count = 0;
    long avg = 0;
    for (Integer i : expenses) {
      sum += i;
      count++;
      if (i > max) {
        max = i;
      }
      if (i < min) {
        min = i;
      }
      avg = sum / count;
    }
    System.out.printf("We spent : %d\n", sum);
    System.out.printf("The highest expense : %d\n", max);
    System.out.printf("The lowest expense : %d\n", min);
    System.out.printf("The average of spending : %d\n", avg);

  }
}
