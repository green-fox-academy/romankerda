package Recursion;

public class MaxSum {
  public static void main(String[] args) {
    // Create a function called `maxSum` which
// expects an array of five integers as an input parameter and
// returns the maximum values that can be
// calculated by summing exactly four of the five integers.
//
// Examples
//
// [1 2 3 4 5] -> 14
//
// We can calculate the following sums using four of the five integers:
//
// 1 + 2 + 3 + 4 = 10
// 1 + 2 + 3 + 5 = 11
// 1 + 2 + 4 + 5 = 12
// 1 + 3 + 4 + 5 = 13
// 2 + 3 + 4 + 5 = 14

    int[] input = {1, 2, 3, 4, 5};
    System.out.println(maxSum(input, 0));
  }

  public static int maxSum(int[] input, int index) {
    if (index == input.length) {
        return 0;
    }
    int sum = 0;
    for (int i = 0; i < input.length; i++) {
      sum += input[i];
    }
    if (sum - input[index] > (maxSum(input, index + 1))) {
      return sum - input[index];
    }
    return maxSum(input, index + 1);
  }
}