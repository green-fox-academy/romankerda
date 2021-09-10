package Arrays;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Matrix {
  public static void main(String[] args) {

    // - Create a two dimensional array dynamically with the following content.
    //   Note that a two dimensional array is often called matrix if every
    //   internal array has the same length.
    //   Use a loop!
    //
    //   1 0 0 0
    //   0 1 0 0
    //   0 0 1 0
    //   0 0 0 1
    //
    //   Its length should depend on a variable
    //
    // - Print this two dimensional array to the output

    int size = 4;
    int[][] matrix = new int[size][size];

    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (row == col) {
          matrix[row][col] = 1;
        } else matrix [row][col] = 0;
      }
    }

    for (int i = 0; i < matrix.length ; i++) {
      for (int j = 0; j < matrix[i].length ; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
