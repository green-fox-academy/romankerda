package Functions;

public class Summing {
  public static void main(String[] args) {

    // Create the usual class wrapper and main method on your own

    // Write a function called `sum()` that returns the sum of numbers from zero to the given parameter

    int end = 100;
    System.out.println(sum(end));
  }

  public static int sum(int end) {
    int sum = 0;
    for (int i = 0; i < end; i++) {
      sum += i;
    }
    return sum;
  }
}
