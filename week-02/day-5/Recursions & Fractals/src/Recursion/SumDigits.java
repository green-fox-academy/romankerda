package Recursion;

public class SumDigits {
  public static void main(String[] args) {
// Given a non-negative integer n, return the sum of it's digits recursively
// (without loops).
//
// Hint
//
// Mod (%) by 10 yields the rightmost digit (e.g. 126 % 10 is 6)
//
// Divide (/) by 10 removes the rightmost digit (e.g. 126 / 10 is 12).

  int n = 123;
    System.out.println(sumDigits(n));
  }

  public static int sumDigits(int n) {
    if (n / 10 == 0) {
      return n % 10;
    }
    return n % 10 + sumDigits( n / 10);
  }

}
