package Functions;

import java.util.Arrays;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes an array of numbers as a parameter
    //  and returns an array of integers where every integer is unique (occurs only once)

    //  Example
    System.out.println(Arrays.toString(findUniqueItems(new int[] {1, 11, 34, 11, 52, 61, 1, 34})));
    //  should print: `[1, 11, 34, 52, 61]`
    System.out.println(Arrays.toString(findUniqueItems(new int[] {1, 2, 3, 4, 2, 4, 11, 33})));
  }


  public static int[] findUniqueItems(int[] array) {
    int[] outputLong = new int[array.length];
    int pos = 0;
    for (int i = 0; i < array.length; i++) {
      if (isUnique(array[i], array)) {
        outputLong[pos] = array[i];
        pos++;
      }
    }
    int[] outputClean = new int[pos];
    for (int i = 0; i <outputClean.length ; i++) {
      outputClean[i] = outputLong[i];
    }
    return outputClean;
  }

  public static boolean isUnique(int num, int[] array) {
    int occurencies = 0;
    for (int n : array) {
      if (n == num) {
        occurencies++;
      }
    }
    if (occurencies == 1) {
      return true;
    }
    return false;
  }
}