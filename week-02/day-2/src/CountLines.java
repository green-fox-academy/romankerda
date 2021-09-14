import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
  public static void main(String[] args) {
//    Write a function that takes a filename as string as a parameter
//    and returns the number of lines the file contains.
//    It should return zero if it can't open the file
//    and should not raise any error.

    String fileName = "src/my-file1.txt";
    int nrOfLines = countLines(fileName);
    System.out.printf("Number of lines of the file \"%s\" = %d\n", fileName, nrOfLines);
  }

  public static int countLines(String fileName) {
    Path path = Paths.get(fileName);
    try {
      List<String> lines = Files.readAllLines(path);
      return lines.size();
    } catch (IOException e) {
      return 0;
    }
  }
}
