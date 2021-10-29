import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.isUpperCase;

public class Exercise6 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the uppercase characters in a string!

    String input = "Write a Stream Expression to find the uppercase characters in a string!";
    char[] inputArr = input.toCharArray();


    List<Character> output = input.chars()
            .filter(Character::isUpperCase)
            .mapToObj(ch -> (char)ch)
            .collect(Collectors.toList());

    System.out.println(Arrays.asList(output));
  }
}
