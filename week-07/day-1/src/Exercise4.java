import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Exercise4 {
  public static void main(String[] args) {
    // Write a Stream Expression to get the average value of the odd numbers from the following list:
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(n -> n)
            .average()
            .ifPresent(avg -> System.out.printf("Average of odd numbers = %s\n", avg));
  }
}
