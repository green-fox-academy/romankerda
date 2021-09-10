package Functions;

public class Factorial {
  public static void main(String[] args) {

    //  Create the usual class wrapper and main method on your own

    // - Create a function called `calculateFactorial()`
    //   that returns the factorial of its input

    int number = 10;
    System.out.println(calculateFactorial(number));
  }

  public static double calculateFactorial(int num) {
    double factorial = 1;
    for (int i = 1; i <= num; i++) {
      factorial *= i;
    }
    return factorial;
  }
}
