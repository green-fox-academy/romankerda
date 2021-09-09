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

        // Diamond can be only size of min. 3 and odd nr. (otherwise can't be symetric)
        System.out.println("How many lines should diamond have? (minimum is 3, must be odd nr.):");
        int lines = scanner.nextInt();
        if (lines < 3 || lines % 2 == 0) {
            System.out.println("Try again, nr. must be odd & at least 3 :");
            return;
        }

        // 1st step: draw pyramid, size of lines/2+1
        int linesPyr = lines / 2 + 1;

        for (int i = 1; i < linesPyr + 1; i++) {             // go through each line
            for (int j = 0; j < linesPyr-i; j++) {
                System.out.print(" ");                      // print respective nr. of blanks at each line
            }
            for (int k = 0; k < i * 2 -1; k++) {            // print respective nr. of * at each line
                System.out.print("*");
            }
            System.out.println();                           // go to next line
        }

        // 2nd step: draw the rest
        int linesRest = lines - linesPyr;
        for (int i = 1; i < linesRest +1; i++) {          // for each line of the rest:
            for (int j = 0; j < i; j++) {                   // print the same nr. of " " as is the line nr. of the rest
                System.out.print(" ");
            }
            for (int k = 0; k < lines - i * 2; k++) {       // print lines-i*2 "*"
                System.out.print("*");
            }
            System.out.println(" ");                        // go to next line
        }
    }
}
