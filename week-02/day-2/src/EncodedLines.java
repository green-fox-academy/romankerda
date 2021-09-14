import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {

  public static void main(String[] args) {
    // Create a method that decrypts encoded-lines.txt

    String fileName = "src/encoded-lines.txt";
    String fileDecoded = "src/decoded-lines.txt";
    encode(fileName, fileDecoded);
  }

  public static void encode(String fileName, String fileDecoded) {
    Path path = Paths.get(fileName);
    List<String> lines = new ArrayList<>();

    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.err.println("Cannot read file");
    }

    List<String> output = new ArrayList<>();
    for (String s : lines) {
      String decodedLine = "";
      for (int i = 0; i < s.length(); i++) {
        int offset = -1;
        int positionOld = (int) s.charAt(i);
        int positionNew = positionOld + offset;
        char decodedChar = (char) positionNew;
        if (s.charAt(i) == (' ')) {
          decodedChar = ' ';
        }
        decodedLine += decodedChar;
      }
      output.add(decodedLine);
    }

    Path pathDecoded = Paths.get(fileDecoded);

    try {
      Files.write(pathDecoded, output);
    } catch (IOException e) {
      System.err.println("Cannot write file");
    }
    System.out.println("Decoding successful");
  }
}