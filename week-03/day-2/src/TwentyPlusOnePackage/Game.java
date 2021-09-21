package TwentyPlusOnePackage;

import java.util.Scanner;

public class Game {

  public static void main(String[] args) {

    System.out.println("-".repeat(20) + "Taking new deck" + "-".repeat(20));
    Deck deck = new Deck();
    deck.shuffleDeck();

    System.out.println("-".repeat(20) + "Game starts" + "-".repeat(20));
    int oponnent = (int) (15 + Math.random() * 7);
    System.out.println("Your cards:");
    Hand hand = new Hand();
    hand.addCard(deck.pullRandom());
    hand.addCard(deck.pullRandom());
    System.out.println(hand);

    boolean finish = false;

    while (!finish && hand.getValue() > 0 && hand.getValue() < 22) {
      Scanner scanner = new Scanner(System.in);
      System.out.printf("Press nr. of your choice:  |1| - pull first card      |2| - pull last card      " +
              "|3| - pull random card      |4| - No other card, let's count!\n");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1 -> {
          hand.addCard(deck.pullFirst());
          System.out.printf("You have : \n%s \n", hand);
        }
        case 2 -> {
          hand.addCard(deck.pullLast());
          System.out.printf("You have : \n%s \n", hand);
        }
        case 3 -> {
          hand.addCard(deck.pullRandom());
          System.out.printf("You have : \n%s \n", hand);
        }
        case 4 -> finish = true;
      }
      System.out.println();
    }
      if (hand.getValue() > oponnent && hand.getValue() < 22) {
        System.out.printf("VICTORY!!!, You had %d, the opponnet had %d\n", hand.getValue(), oponnent);
      } else if (hand.getValue() == oponnent) System.out.printf("DRAW!!!, You had %d, our opponnet had %d\n", hand.getValue(), oponnent);
      else System.out.printf("YOU LOST !!!, You had %d, the opponnet had %d\n", hand.getValue(), oponnent);
    }
  }

