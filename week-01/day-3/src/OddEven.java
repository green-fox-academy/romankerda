import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input,
        // then prints "Odd" if the number is odd, or "Even" if it is even

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number: ");
        int input = scanner.nextInt();

        boolean even = input % 2 == 0;

        if (even) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
