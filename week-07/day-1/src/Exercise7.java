import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise7 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:
    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI",
            "AMSTERDAM", "ABU DHABI", "PARIS");

    String letter = "N";
    List<String> startsWithGivenLetter = cities.stream()
            .filter(s -> s.startsWith(letter))
            .collect(Collectors.toList());

    System.out.println("Starts with letter " + letter + ": " + startsWithGivenLetter);
  }
}
