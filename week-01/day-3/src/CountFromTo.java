import java.util.Scanner;

public class CountFromTo {
    public static void main(String[] args) {

        // Create a program that asks for two numbers
        // If the second number is not bigger than the first one it should print:
        // "The second number should be bigger"
        //
        // If it is bigger it should count from the first number to the second by one
        //
        // example:
        //
        // first number: 3, second number: 6, should print:
        //
        // 3
        // 4
        // 5

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write 1st number: ");
        int first = scanner.nextInt();
        System.out.println("Write 2nd number (bigger then 1st number) :");
        int second = scanner.nextInt();

        if (second <= first) {
            System.out.println("The second number should be bigger");
        } else {
            for (int i = first; i < second ; i++) {
                System.out.println(i);
            }
        }




    }
}
