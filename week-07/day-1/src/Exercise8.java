import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise8 {
  public static void main(String[] args) {
    //Write a Stream Expression to concatenate a Character list to a string!

    List<Character> charList = Arrays.asList('H', 'e', 'l', 'l', 'o');

    String output = charList.stream()
            //.map(ch -> ch.toString())
            .map(Object::toString)
            .collect(Collectors.joining());

    System.out.println(output);
  }
}
