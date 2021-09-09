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
        int lines = scanner.nextInt();
        if (lines < 1) {
            System.out.println("Can't do it, try again higher number :");
            return;
        }


        for (int i = 0; i < lines; i++) {               // 1st line
            System.out.print("%");
        }
        System.out.println(" ");                        // go to next line

        for (int i = 0; i < lines - 2; i++) {           // body
            System.out.print("%");                      // 1st % @ given line of the body
            for (int j = 0; j < lines - 2; j++) {
                if (j == i) {                           // check if space should be replaced by % at given line
                    System.out.print("%");
                } else {
                    System.out.print(" ");                  // empty spaces @ given line of the body
                }
            }
            System.out.print("%");                      // last % @ given line
            System.out.println();                       // next line
        }

        if (lines == 1) {                               // no last line if square size = 1
            return;
        }

        for (int i = 0; i < lines; i++) {               // last line
            System.out.print("%");
        }



    }
}
