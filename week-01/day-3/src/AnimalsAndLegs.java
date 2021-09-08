import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many chicken has the farmer?");
        int chickens = scanner.nextInt();
        System.out.println("How many pigs has the farmer?");
        int pigs = scanner.nextInt();
        int totalLegs = 2*chickens + 4*pigs;
        System.out.println("All farmer's animals have " + totalLegs + " legs in total.");


    }
}
