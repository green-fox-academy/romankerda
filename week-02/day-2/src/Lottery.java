import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lottery {

  public static void main(String[] args) {
    // Create a method that find the 5 most common lottery numbers in lottery.csv

    String fileName = "src/lottery.csv";
    System.out.println("The 5 most common lottery numbers : " + Arrays.toString(findNumbers(fileName)));
  }

  public static String[] findNumbers(String fileName) {
    Path path = Paths.get(fileName);
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.err.println("Cannot read file");
    }
    Map<String, Integer> numbers = new HashMap<>();
    for (String s : lines) {
      String[] line = s.split(";");
      for (int i = 11; i < line.length; i++) {
        if (!numbers.containsKey(line[i])) {
          numbers.put(line[i], 1);
        } else {
          numbers.put(line[i], numbers.get(line[i]) + 1);
        }
      }
    }
    String[] top5 = new String[5];
    for (int i = 0; i < 5; i++) {
      int max = 0;
      String maxVal = "";
      for (String s : numbers.keySet()) {
        if (numbers.get(s) > max) {
          max = numbers.get(s);
          maxVal = s;
        }
      }
      top5[i] = maxVal;
//      System.out.printf("number = %s, occurence = %d\n", maxVal, max);
      numbers.remove(maxVal);
    }
    return top5;
  }
}