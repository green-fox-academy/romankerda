package CABPackage;

import java.util.*;

import static java.lang.Integer.parseInt;

public class CaB {

  private String state;
  private String numberToGuess;
  private static List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
  private int counter;


  public CaB() {
    this.state = "playing";
    counter = 0;
    numberToGuess = "";
    Collections.shuffle(numbers);
    for (int i = 0; i < 4; i++) {
      numberToGuess += numbers.get(i);
    }
  }

  public String guess(String guess) {
    int cow = 0;
    int bull = 0;
    counter ++;
      for (int i = 0; i < guess.length(); i++) {
        if (guess.charAt(i) == numberToGuess.charAt(i)) {
          cow ++;
        }
        if (guess.charAt(i) != numberToGuess.charAt(i) && numberToGuess.indexOf(guess.charAt(i)) != -1) {
          bull ++;
        }
      }
      if (cow == 4) {
        this.state = "finished";
      }
      return "" + cow + "C" + bull + "B";
    }


  public String getState() {
    return state;
  }

  public int getCounter() {
    return counter;
  }

  public String getNumberToGuess() {
    return numberToGuess;
  }

  public void setNumberToGuess(String numberToGuess) {
    this.numberToGuess = numberToGuess;
  }
}
