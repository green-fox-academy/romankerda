import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
  public static void main(String[] args) {
    // Write a function that is able to manipulate a file
    // by writing your name into it as a single line.
    // The file should be named "my-file.txt".
    // In case the program is unable to write the file,
    // it should print the following error message: "Unable to write file: my-file.txt".

    String text = "Roman K.";
    String fileName = "src/my-file.txt";
    writeSingleLine(fileName, text);
  }

  public static void writeSingleLine(String fileName, String text) {
    Path path = Paths.get(fileName);
    List<String> firstLine = new ArrayList<>();
    firstLine.add(text);
    try {
      Files.write(path, firstLine);
      System.out.printf("First line \"%s\" successfully written to file \"%s\"\n", firstLine, fileName);
    } catch (IOException e) {
      System.err.printf("Unable to write file: %s\n", fileName);
    }
  }
}