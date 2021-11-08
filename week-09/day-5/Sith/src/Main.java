public class Main {
  public static void main(String[] args) {
    Reverser reverser = new Reverser();
    reverser.setText("This is my example sentence. Just for fun. Lets test it. Thoroughly my young padawan.");
    reverser.reverse();

    System.out.println(reverser.getSith_text());

  }
}
