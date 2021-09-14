import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
  public static void main(String[] args) {
//     Write a program that opens a file called "my-file.txt2" and prints each
//     line from the file.
//     If the program is unable to read the file (for example the file does not exist),
//     it should print the following error message: "Unable to read file: my-file.txt2".

    Path filePath = Paths.get("src/my-file.txt");
    try {
      List<String> lines = Files.readAllLines(filePath);
      for (String s : lines) {
        System.out.println(s);
      }
    } catch (IOException e) {
      System.err.println("Unable to read file: my-file.txt2");
    }
  }
}