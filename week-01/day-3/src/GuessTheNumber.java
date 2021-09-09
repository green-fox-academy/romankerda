import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        // Write a program that stores a number and the user has to figure it out
        // The user can input guesses
        // After each guess the program would tell one of the following:
        //
        // The stored number is higher
        // The stored number is lower
        // You found the number: 8


        // generate random integer nr between 0 and 100.:
        Random rn = new Random();
        int guessMe = rn.nextInt() % 100;
        int num;

        System.out.println("I am a random number, guess me: ");

        do {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if (num > guessMe) {
                System.out.println("The stored nr. is lower");
            } else if (num < guessMe) {
                System.out.println("The stored nr. is higher");
            }
        } while (num != guessMe);

        System.out.println("You found the number, it was: " + guessMe);
    }
}
