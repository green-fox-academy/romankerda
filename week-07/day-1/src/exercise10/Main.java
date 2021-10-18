package exercise10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  /* Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:

  Write a Stream Expression to find the foxes with green color!
  Write a Stream Expression to find the foxes with green color, and age less then 5 years!
  Write a Stream Expression to find the frequency of foxes by color!
  */

  public static void main(String[] args) {
    List<Fox> foxes = Arrays.asList(new Fox("One", "blue", 5),
            new Fox("Two", "blue", 5),
            new Fox("Three", "yellow", 7),
            new Fox("Four", "green", 5),
            new Fox("Five", "green", 3),
            new Fox("Six", "red", 6),
            new Fox("Seven", "blue", 3));

    System.out.println("Green color: ");
    foxes.stream()
            .filter(f -> f.getColor().equals("green"))
            .forEach(System.out::println);

    System.out.println("\nGreen color and less then 5 yrs: ");
    foxes.stream()
            .filter(f -> f.getColor().equals("green") && f.getAge() < 5)
            .forEach(System.out::println);

    System.out.println("\nFrequency of foxes by color: ");
    Map<String, Long> frequency = foxes.stream()
            .collect(Collectors.groupingBy(Fox::getColor, Collectors.counting()));

    System.out.println(frequency);
    frequency.forEach((k,v) ->
            System.out.println(k + " -- " + v)
    );
  }
}
