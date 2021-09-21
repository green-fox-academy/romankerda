package DiceSetPackage;

import java.util.ArrayList;
import java.util.List;

public class DiceSet {
  ArrayList<Integer> dice = new ArrayList<>();

  public List<Integer> rollSet() {
    for (int i = 0; i < 6; i++) {
      dice.add((int) (Math.random() * 6) + 1);
    }
    return dice;
  }

  public List<Integer> getCurrentSet() {
    return dice;
  }

  public int getCurrentItem(int i) {
    return dice.get(i);
  }

  public void rerollSet() {
    for (int i = 0; i < dice.size(); i++) {
      dice.set(i, (int) (Math.random() * 6) + 1);
    }
  }

  public void rerollItem(int k) {
    dice.set(k, (int) (Math.random() * 6) + 1);
  }

  public static void main(String[] args) {
    // You have a `DiceSet` class which has a list for 6 dice
    // You can roll all of them with the rollSet() method
    // You can check the current rolled numbers with getCurrentSet() and getCurrentItem() method
    // You can reroll all with the rerollSet(), or reroll one with the rerollItem() method
    // Your task is to roll the dice until all of the dice are 6

    int countAttempts = 0;
    int count6 = 0;

    DiceSet diceSet = new DiceSet();
    diceSet.rollSet();
    countAttempts++;
    System.out.println(diceSet.getCurrentSet());


    do {
      diceSet.rerollSet();
      countAttempts++;
      System.out.println(diceSet.getCurrentSet());
      count6 = 0;
      for (int i = 0; i < 6; i++) {
        if (diceSet.dice.get(i) == 6) count6++;
      }
    }
    while (count6 < 2);

    for (int i = 0; i < 6; i++) {
      while (diceSet.dice.get(i) != 6) {
        diceSet.rerollItem(i);
        countAttempts++;
        System.out.println(diceSet.getCurrentSet());
      }
    }
    System.out.printf("\n%s attempts needed\n", countAttempts);
  }
}