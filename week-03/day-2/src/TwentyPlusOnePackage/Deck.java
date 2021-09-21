package TwentyPlusOnePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

  private final List<Card> list;


  public Deck() {
    list = new ArrayList<>();
    for (Card.Color color : Card.Color.values()) {
      for (Card.Suit suit : Card.Suit.values()) {
        for (Card.Rank rank : Card.Rank.values()) {
          list.add(new Card(color, suit, rank));
        }
      }
    }
  }

  public void shuffleDeck() {
    Random random = new Random();
    List<Card> shuffled = new ArrayList<>();
    for (int i = 0; i < 104; i++) {
      int randCard = random.nextInt(104-i);
      shuffled.add(list.get(randCard));
      list.remove(randCard);
    }
    list.addAll(shuffled);
  }

  public Card pullFirst() {
    Card first = list.get(0);
    list.remove(0);
    return first;
  }

  public Card pullLast() {
    Card last = list.get(list.size()-1);
    list.remove(list.size()-1);
    return last;
  }

  public Card pullRandom() {
    Random random = new Random();
    int randCardNr = random.nextInt(list.size()-1);
    Card randCard = list.get(randCardNr);
    list.remove(randCardNr);
    return randCard;
  }


  @Override
  public String toString() {
    return "" + list;
  }
}










