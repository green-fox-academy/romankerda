import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Births {
  public static void main(String[] args) {
    // Create a function that
    // - takes the name of a CSV file as a parameter,
    //   - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
    // - and returns the year when the most births happened.
    //   - if there were multiple years with the same number of births then return any of them

    // You can find such a CSV file in this directory named births.csv
    // If you pass "births.csv" to your function, the result should be either 2006 or 2016

    String fileName = "src/births.csv";
    String year = yearMostBirth(fileName);
    System.out.println(year);
  }

  public static String yearMostBirth(String fileName) {
    Path path = Paths.get(fileName);
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.err.println("Could not read file");
    }

    Map<String, Integer> births = new HashMap<>();
    for (String s : lines) {
      String [] line = s.split(";");
      if (!births.containsKey(line[1].substring(0,4))) {
        births.put(line[1].substring(0, 4), 1);
      } else {
        births.put(line[1].substring(0, 4), births.get(line[1].substring(0, 4)) + 1);
      }
    }
    int max = 0;
    String yearMax = "";
    for (String s : births.keySet()) {
      if (births.get(s) > max) {
        max = births.get(s);
        yearMax = s;
      }
    }
    return yearMax;
  }
}
