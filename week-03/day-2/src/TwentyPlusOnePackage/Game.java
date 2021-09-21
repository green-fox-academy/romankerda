package TwentyPlusOnePackage;

public class Game {

  public static void main(String[] args) {

    System.out.println("-".repeat(20) + "Take new deck" + "-".repeat(20));
    Deck deck = new Deck();
    System.out.println(deck);

    System.out.println("-".repeat(20) + "Shuffle the deck" + "-".repeat(20));


    deck.shuffleDeck();
    System.out.println(deck);

    System.out.println(deck.pullFirst());
    System.out.println(deck.pullLast());
    System.out.println(deck.pullRandom());
  }
}
