package Recursion;

public class NumberAdder {
  public static void main(String[] args) {
    int n = 15;
    System.out.println(addNumbers(n));
  }

  public static int addNumbers(int n) {
    if (n == 0) {
      return 0;
    }
   return n + addNumbers(n - 1);
  }
}
