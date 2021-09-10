package Arrays;

import java.util.Arrays;

public class ReverseList {
  public static void main(String[] args) {

    // - Create an array variable named `numbers`
    //   with the following content: `[3, 4, 5, 6, 7]`
    // - Reverse the order of the elements of `numbers`
    // - Print the elements of the reversed `numbers`

    int[] numbers = {3, 4, 5, 6, 7};
    int[] numbersReverted = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      numbersReverted[i] = numbers[numbers.length-1-i];
    }
    System.out.println(Arrays.toString(numbersReverted));
  }
}
