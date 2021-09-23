package Printable;

public class Domino implements Printable {

  private int left;
  private int right;

  public Domino(int left, int right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public void printAllFields() {
    System.out.println("Domino A side: " + left + ", B side: " + right);
  }
}
