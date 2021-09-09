import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program that asks for a double that is a distance in miles,
        // then it converts that value to kilometers and prints it

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input distance in miles:");
        double distMiles = scanner.nextDouble();
        double distKm = distMiles * 1.61;
        System.out.println(distMiles + " miles is " + distKm + " km");
    }
}
