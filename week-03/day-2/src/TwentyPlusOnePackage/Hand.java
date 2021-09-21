package TwentyPlusOnePackage;

import java.util.ArrayList;
import java.util.List;

public class Hand {

  private List<Card> hand;

  public Hand() {
    hand = new ArrayList<>();
  }

  public void addCard(Card card) {
    hand.add(card);
  }

  public int getValue() {
    int value = 0;
    for (Card card : hand) {
      value += card.getRank().getValue();
    }
    return value;
  }

  @Override
  public String toString() {
    String print = "";
    for (int i = 0; i < hand.size(); i++) {
      print += hand.get(i);
    }
    return print;
  }
}
