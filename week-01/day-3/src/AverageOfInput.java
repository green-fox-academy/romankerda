import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {
        // Write a program that asks for 5 integers in a row,
        // then it should print the sum and the average of these numbers like:
        //
        // Sum: 22, Average: 4.4

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert 1st number : ");
        int sum = scanner.nextInt();
        System.out.println("Insert 2nd number : ");
        sum += scanner.nextInt();
        System.out.println("Insert 3rd number : ");
        sum += scanner.nextInt();
        System.out.println("Insert 4th number : ");
        sum += scanner.nextInt();
        System.out.println("Insert 5th number : ");
        sum += scanner.nextInt();

        double avg = sum / 5.;
        System.out.println("Sum: " + sum + ", Average: " + avg);
    }
}
