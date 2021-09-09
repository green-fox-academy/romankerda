import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {

        // Write a program that reads a number from the standard input, then draws a
        // diamond like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // The diamond should have as many lines as the number was


        Scanner scanner = new Scanner(System.in);

        // Diamond can be only size of min. 3 and odd nr. (otherwise can't be symmetric)
        System.out.println("How many lines should diamond have? (minimum is 3, must be odd nr.):");
        int size = scanner.nextInt();
        if (size < 3 || size % 2 == 0) {
            System.out.println("Try again, nr. must be odd & at least 3 :");
            return;
        }

        for (int i = -size/2; i < size/2+1; i++) {
            for (int col = -size/2; col < size/2+1; col++) {
                if ((Math.abs(i) + Math.abs(col)) <= size/2) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}