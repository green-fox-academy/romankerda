import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logs {
  public static void main(String[] args) {
    // Read all data from 'log.txt'
    // Each line represents a log message from a web server
    // Write a function that returns an array with the unique IP adresses
    // Write a function that returns the GET / POST request ratio


    String sourceFile = "src/log.txt";
    Path path = Paths.get(sourceFile);
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.err.println("Could not read source file");
    }

    String[] IPs = getIPs(lines);
    double ratioGP = getGPRation(lines);

    System.out.println(Arrays.toString(IPs));
    System.out.printf("GET / POST ratio = %.2f", ratioGP);
  }

  public static String[] getIPs(List<String> input) {
    List<String> outputArrList = new ArrayList<>();
    for (String s : input) {
      String[] lineData = s.split(" ");
      if (!outputArrList.contains(lineData[8])) {
        outputArrList.add(lineData[8]);
      }
    }
    String[] output = new String[outputArrList.size()];
    for (int i = 0; i < output.length; i++) {
      output[i] = outputArrList.get(i);
    }
    return output;
  }

  public static double getGPRation(List<String> input) {
    int countGet = 0;
    int countPost = 0;
    for (String s : input) {
      String[] lineData = s.split(" ");
        if (lineData[11].equals("GET")) {
          countGet++;
        }
        if (lineData[11].equals("POST")) {
          countPost++;
        }
    }
    return (double) countGet / countPost;
  }
}
