package CABPackage;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    play();
  }

  public static void play() {
    String result = "";
    CaB game = new CaB();
    String correctGuess = "4C0B";
    boolean guessed = false;
//    System.out.println(game.getNumberToGuess());

    do {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Guess...\n");
      String guess = scanner.next();
      int test = 0;
      for (int i = 0; i < guess.length(); i++) {
        if (guess.substring(i + 1, guess.length()).indexOf(guess.charAt(i)) != -1) {
          test = 1;
        }
      }
      if (guess.length() == 4 && test == 0) {
        result = game.guess(guess);
        System.out.println(result);
        guessed = result.equals(correctGuess);
        if (guessed) {
          System.out.println("You are winner");
          System.out.println("Attempts needed: " + game.getCounter());
        }
      } else {
        System.out.println("Incorrect input, try again");
      }
    }
    while (game.getState() != "finished");
  }
}
