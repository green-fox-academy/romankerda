package Functions;

import java.util.Arrays;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes an array of numbers as a parameter
    //  and returns an array of integers where every integer is unique (occurs only once)

    //  Example
    System.out.println(Arrays.toString(findUniqueItems(new int[] {1, 11, 34, 11, 52, 61, 1, 34})));
    //  should print: `[1, 11, 34, 52, 61]`
  }

  public static int[] findUniqueItems(int[] input) {
    int count = 0;
    int[] output = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      if (!contains(output, input[i])) {
        output[count] = input[i];
        count++;
      }
    }
    int[] outputClean = Arrays.copyOfRange(output, 0, count);
    return outputClean;
  }

  public static boolean contains(int[] array, int value) {
    for (int i = 0; i < array.length; i++) {
      if (value == array[i]) {
        return true;
      }
    }
    return false;
  }
}