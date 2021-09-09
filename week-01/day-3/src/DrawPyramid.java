import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {

        // Write a program that reads a number from the standard input, then draws a
        // pyramid like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //
        // The pyramid should have as many lines as the number was

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many line should pyramid have? :");
        int size = scanner.nextInt();

        for (int row = -size; row < 1; row++) {
            for (int col = -size+1; col < size; col++) {
                if ((Math.abs(row) + Math.abs(col)) < size) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}

