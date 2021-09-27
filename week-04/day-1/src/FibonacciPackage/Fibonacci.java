package FibonacciPackage;

public class Fibonacci {

  public Fibonacci() {
  }

  public int calc(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
  return calc(n - 2) + calc (n - 1);
  }


}
