import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {

  public static void main(String[] args) {
    // Create a method that decrypts reversed-lines.txt
    String encryptedFile = "src/ReversedLines-source.txt";
    String decryptedFile = "src/ReversedLines-output.txt";

    decrypt (encryptedFile, decryptedFile);
  }

  public static void decrypt(String input, String output) {
    Path pathInp = Paths.get(input);
    Path pathOut = Paths.get(output);
    List<String> inputLines = new ArrayList<>();
    List<String> outputLines = new ArrayList<>();

    try {
      inputLines = Files.readAllLines(pathInp);
    } catch (IOException e) {
      System.err.println("Could not read file");
    }

    for (String s : inputLines) {
      String decrLine = "";
      for (int i = s.length()-1; i > -1 ; i--) {
        decrLine += s.charAt(i);
      }
      outputLines.add(decrLine);
    }

    try {
      Files.write(pathOut, outputLines);
    } catch (IOException e) {
      System.err.println("Could not write file");
    }
    System.out.printf("File content of file \"%s\" decrypted to file \"%s\"\n", input, output);
  }
}