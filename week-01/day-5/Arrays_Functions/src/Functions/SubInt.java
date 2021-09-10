package Functions;

import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    //  Create a function that takes a number and an array of integers as parameters
    //  It returns the indices of the integers of the array which contain the given number
    //  or returns an empty array (if the number is not part of any of the integers in the array)

    //  Examples:
    System.out.println(Arrays.toString(findMatchingIndexes(1, new int[] {1, 11, 34, 52, 61})));
    //  should print: `[0, 1, 4]`
    System.out.println(Arrays.toString(findMatchingIndexes(9, new int[] {1, 11, 34, 52, 61})));
    //  should print: '[]'

    // Note: We are using Arrays.toString() function to print the array returned
    // You could just as well iterate over the array and print its items one by one



  }

  public static int[] findMatchingIndexes(int number, int[] array) {

    int matches = 0;
    String numberString = String.valueOf(number);
    int[] outputLong = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      String arrayNrString = String.valueOf(array[i]);
      outputLong[i] = arrayNrString.indexOf(numberString);
      if (arrayNrString.indexOf(numberString) != -1) {
        matches++;
      }
    }

    int[] outputClean = new int[matches];
    int pos = 0;
    for (int j = 0; j < outputLong.length; j++) {
      if (outputLong[j] != -1) {
        outputClean[pos] = j;
        pos++;
      }
    }
    return outputClean;
  }
}