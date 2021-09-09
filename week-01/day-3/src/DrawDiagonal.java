import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {

        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%
        // %%  %
        // % % %
        // %  %%
        // %%%%%
        //
        // The square should have as many lines as the number was

        /*
        same as DrawSquare + enhanced body: for each line draw % instead of space
        at respective position, ie. 1st line of body : 1st space to be replaced by %,
        2nd line 2nd space  etc.
         */

        // 1st and last line: print the same nr. of % as the size
        // the rest(body) : nr. of lines size - 2, print % at the beginning, then size - 2 " ", then % at the end

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many lines should square have? :");
        int size = scanner.nextInt();
        if (size < 1) {
            System.out.println("Can't do it, try again higher number :");
            return;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == 0 || col == 0 || row == size-1 || col == size-1 || row == col) {
                    System.out.print("%");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
