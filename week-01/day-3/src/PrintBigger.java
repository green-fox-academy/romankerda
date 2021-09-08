import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {
        // Write a program that asks for two numbers and prints the bigger one

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write 1st number: ");
        int a = scanner.nextInt();
        System.out.println("Write 2nd number: ");
        int b = scanner.nextInt();

        if (a > b) {
            System.out.println("Bigger one = " + a);
        } else if (a < b) {
            System.out.println("Bigger one = " + b);
        } else {
            System.out.println("Same numbers");
        }

    }
}
