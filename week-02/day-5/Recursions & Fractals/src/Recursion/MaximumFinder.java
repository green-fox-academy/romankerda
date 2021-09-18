package Recursion;

public class MaximumFinder {
  public static void main(String[] args) {
    // Write a function that finds the largest element of an array using recursion.

    int[] input = {1, 44, 5};
    System.out.println(findMax(input, 0));
  }

  public static int findMax(int[] input, int index) {
    if (index == input.length) {
      return 0;
    }
    if (input[index] > findMax(input, index + 1)) {
      return input[index];
    }
    return findMax(input, index + 1);
  }
}

