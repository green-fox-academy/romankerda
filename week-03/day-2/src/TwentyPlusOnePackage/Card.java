package TwentyPlusOnePackage;

public class Card {

  public enum Color {RED, BLACK}

  public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}

  public enum Rank {

    TWO(2), THREE(3), FOUR(4), FIVE (5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), J(1), Q(1), K(2), A(11);

    private final int value;
    private Rank (int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  private Color color;
  private Suit suit;
  private Rank rank;


  public Card(Color color, Suit suit, Rank rank) {
    this.color = color;
    this.suit = suit;
    this.rank = rank;
  }

  public Rank getRank() {
    return rank;
  }

  @Override
  public String toString() {
    return ""+ color + " " + suit + " " + rank + "\n";
  }
}
