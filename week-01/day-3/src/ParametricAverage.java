import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {

        // Write a program that asks for a number
        // It would ask this many times to enter an integer
        // If all the integers are entered it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4


        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        double avg;

        System.out.println("How many numbers do you want to enter? :");
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Enter number, " + "(" + (i+1) + "/" + num + "):");
            sum += scanner.nextInt();
        }
        avg = (double) sum / num;
        System.out.println("Sum: " + sum +", Average: " + avg);
    }
}
