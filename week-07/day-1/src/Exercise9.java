import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.toLowerCase;

public class Exercise9 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the frequency of characters in a given string!

    String input = "Hello World What?";

    Map<Character, Long> frequency = input.chars()
            .mapToObj(ch -> (char)toLowerCase(ch))
            .filter(Character::isAlphabetic)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(frequency);
  }
}
