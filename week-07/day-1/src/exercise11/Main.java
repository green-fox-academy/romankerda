package exercise11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    String input = "src/exercise11/text.txt";
    List<String> words = new ArrayList<>();

    try {
      List<String> fileLines = Files.readAllLines(Paths.get(input));
      for (String line : fileLines) {
        String[] wordsArr = line.split("[^a-zA-Z]");
        words.addAll(Arrays.asList(wordsArr));
      }
    } catch (IOException e) {
      System.err.println("Can't read file");
    }

    Map<String, Long> frequency = words.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    frequency.entrySet().stream()
            .filter(e -> !e.getKey().equals(""))
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(100)
            .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
  }
}
