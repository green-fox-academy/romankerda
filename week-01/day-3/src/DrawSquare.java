import java.util.Scanner;

public class DrawSquare {
    public static void main (String[] args) {

        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%%
        // %    %
        // %    %
        // %    %
        // %    %
        // %%%%%%
        //
        // The square should have as many lines as the number was


        // 1st and last line: print the same nr. of % as the size
        // the rest(body) : nr. of lines size - 2, print % at the beginning, then size - 2 " ", then % at the end

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many lines should square have? :");
        int lines = scanner.nextInt();
        if (lines < 1) {
            System.out.println("Can't do it, try again higher number :");
            return;
        }

        for (int row = 0; row < lines; row++) {
            for (int col = 0; col < lines; col++) {
                if (row == 0 || col == 0 || row == lines-1 || col == lines-1) {
                    System.out.print("%");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }


}
