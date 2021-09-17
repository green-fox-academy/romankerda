package Recursion;

public class GratestCommonDivisor {
  public static void main(String[] args) {
    // Find the greatest common divisor of two numbers using recursion.

    System.out.println(findDivider(1200, 1503, 2));

  }

  public static int findDivider(int a, int b, int n) {
    if (n == a || n == b) {
      return 1;
    }
    if (a % n == 0 && b % n == 0) {
      return n;
    }
    return findDivider( a, b, n+1);
  }
}
