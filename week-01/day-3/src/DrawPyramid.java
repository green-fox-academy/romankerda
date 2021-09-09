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
        int lines = scanner.nextInt();

        for (int i = 1; i < lines +1; i++) {                // go through each line
            for (int j = 0; j < lines-i; j++) {
                System.out.print(" ");                      // print respective nr. of blanks at each line
            }
            for (int k = 0; k < i * 2 -1; k++) {            // print respective nr. of * at each line
                System.out.print("*");
            }
            System.out.println();                           // go to next line
        }
    }
}
