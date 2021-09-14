import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
//    Create a function that divides number 10
//    by a number that's passed as a paramater and prints the result.
//    It should print "fail" if the parameter is 0

    Scanner scanner = new Scanner(System.in);
    System.out.println("Insert number: ");
    int divider = scanner.nextInt();

    try {
      double result = 10 / divider;
      System.out.printf("10 / %d = %.2f", divider, result);
    } catch (ArithmeticException e) {
      System.err.println("fail");
    }
  }
}
